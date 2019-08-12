package com.entanmo.etmall.core.service;

import com.entanmo.etmall.core.dao.IOrder;
import com.entanmo.etmall.core.util.OrderUtil;
import com.entanmo.etmall.db.dao.EtmallOrderMapper;
import com.entanmo.etmall.db.domain.EtmallOrder;
import com.entanmo.etmall.db.domain.EtmallOrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Resource
    private EtmallOrderMapper EtmallOrderMapper;
//    @Resource
    private IOrder iOrder;


    public int updateWithOptimisticLocker(EtmallOrder order) {
        LocalDateTime preUpdateTime = order.getUpdateTime();
        order.setUpdateTime(LocalDateTime.now());
        return iOrder.updateWithOptimisticLocker(preUpdateTime, order);
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
}
