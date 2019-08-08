package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallOrderMapper;
import com.entanmo.etmall.db.domain.EtmallOrder;
import com.entanmo.etmall.db.domain.EtmallOrderExample;
import com.entanmo.etmall.db.util.OrderUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class EtmallOrderService {

    @Resource
    private EtmallOrderMapper EtmallOrderMapper;
//    @Resource
//    private IOrder orderMapper;

    public int add(EtmallOrder order) {
        order.setAddTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        return EtmallOrderMapper.insertSelective(order);
    }

    public int count(Integer userId) {
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return (int) EtmallOrderMapper.countByExample(example);
    }

    public EtmallOrder findById(Integer orderId) {
        return EtmallOrderMapper.selectByPrimaryKey(orderId);
    }

    private String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public int countByOrderSn(Integer userId, String orderSn) {
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andUserIdEqualTo(userId).andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return (int) EtmallOrderMapper.countByExample(example);
    }

    // TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
    public String generateOrderSn(Integer userId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = df.format(LocalDate.now());
        String orderSn = now + getRandomNum(6);
        while (countByOrderSn(userId, orderSn) != 0) {
            orderSn = now + getRandomNum(6);
        }
        return orderSn;
    }

    public List<EtmallOrder> queryByOrderStatus(Integer userId, List<Short> orderStatus, Integer page, Integer limit, String sort, String order) {
        EtmallOrderExample example = new EtmallOrderExample();
        example.setOrderByClause(EtmallOrder.Column.addTime.desc());
        EtmallOrderExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        if (orderStatus != null) {
            criteria.andOrderStatusIn(orderStatus);
        }
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return EtmallOrderMapper.selectByExample(example);
    }

    public List<EtmallOrder> querySelective(Integer userId, String orderSn, List<Short> orderStatusArray, Integer page, Integer limit, String sort, String order) {
        EtmallOrderExample example = new EtmallOrderExample();
        EtmallOrderExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(orderSn)) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        if (orderStatusArray != null && orderStatusArray.size() != 0) {
            criteria.andOrderStatusIn(orderStatusArray);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return EtmallOrderMapper.selectByExample(example);
    }

//    public int updateWithOptimisticLocker(EtmallOrder order) {
//        LocalDateTime preUpdateTime = order.getUpdateTime();
//        order.setUpdateTime(LocalDateTime.now());
//        return orderMapper.updateWithOptimisticLocker(preUpdateTime, order);
//    }

    public void deleteById(Integer id) {
        EtmallOrderMapper.logicalDeleteByPrimaryKey(id);
    }

    public int count() {
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andDeletedEqualTo(false);
        return (int) EtmallOrderMapper.countByExample(example);
    }

    public List<EtmallOrder> queryUnpaid(int minutes) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusMinutes(minutes);
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_CREATE).andAddTimeLessThan(expired).andDeletedEqualTo(false);
        return EtmallOrderMapper.selectByExample(example);
    }

    public List<EtmallOrder> queryUnconfirm(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_SHIP).andShipTimeLessThan(expired).andDeletedEqualTo(false);
        return EtmallOrderMapper.selectByExample(example);
    }

    public EtmallOrder findBySn(String orderSn) {
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return EtmallOrderMapper.selectOneByExample(example);
    }

    public Map<Object, Object> orderInfo(Integer userId) {
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        List<EtmallOrder> orders = EtmallOrderMapper.selectByExampleSelective(example, EtmallOrder.Column.orderStatus, EtmallOrder.Column.comments);

        int unpaid = 0;
        int unship = 0;
        int unrecv = 0;
        int uncomment = 0;
        for (EtmallOrder order : orders) {
            if (OrderUtil.isCreateStatus(order)) {
                unpaid++;
            } else if (OrderUtil.isPayStatus(order)) {
                unship++;
            } else if (OrderUtil.isShipStatus(order)) {
                unrecv++;
            } else if (OrderUtil.isConfirmStatus(order) || OrderUtil.isAutoConfirmStatus(order)) {
                uncomment += order.getComments();
            } else {
                // do nothing
            }
        }

        Map<Object, Object> orderInfo = new HashMap<Object, Object>();
        orderInfo.put("unpaid", unpaid);
        orderInfo.put("unship", unship);
        orderInfo.put("unrecv", unrecv);
        orderInfo.put("uncomment", uncomment);
        return orderInfo;

    }

    public List<EtmallOrder> queryComment(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        EtmallOrderExample example = new EtmallOrderExample();
        example.or().andCommentsGreaterThan((short) 0).andConfirmTimeLessThan(expired).andDeletedEqualTo(false);
        return EtmallOrderMapper.selectByExample(example);
    }
}
