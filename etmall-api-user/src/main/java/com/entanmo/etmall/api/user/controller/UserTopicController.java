package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.core.validator.Order;
import com.entanmo.etmall.core.validator.Sort;
import com.entanmo.etmall.db.domain.EtmallGoods;
import com.entanmo.etmall.db.domain.EtmallTopic;
import com.entanmo.etmall.db.service.EtmallGoodsService;
import com.entanmo.etmall.db.service.EtmallTopicService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专题服务
 */
@RestController
@RequestMapping("/user/topic")
@Validated
public class UserTopicController {
//    private final Log logger = LogFactory.getLog(UserTopicController.class);

//    @Autowired
    private EtmallTopicService topicService;
//    @Autowired
    private EtmallGoodsService goodsService;

    /**
     * 专题列表
     */
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<EtmallTopic> topicList = topicService.queryList(page, limit, sort, order);
        return ResponseUtil.okList(topicList);
    }

    /**
     * 专题详情
     */
    @GetMapping("detail")
    public Object detail(@NotNull Integer id) {
        EtmallTopic topic = topicService.findById(id);
        List<EtmallGoods> goods = new ArrayList<>();
        for (Integer i : topic.getGoods()) {
            EtmallGoods good = goodsService.findByIdVO(i);
            if (null != good)
                goods.add(good);
        }

        Map<String, Object> entity = new HashMap<String, Object>();
        entity.put("topic", topic);
        entity.put("goods", goods);
        return ResponseUtil.ok(entity);
    }

    /**
     * 相关专题
     */
    @GetMapping("related")
    public Object related(@NotNull Integer id) {
        List<EtmallTopic> topicRelatedList = topicService.queryRelatedList(id, 0, 4);
        return ResponseUtil.okList(topicRelatedList);
    }
}