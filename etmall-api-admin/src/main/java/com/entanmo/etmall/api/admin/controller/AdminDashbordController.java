package com.entanmo.etmall.api.admin.controller;

import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.db.service.EtmallGoodsProductService;
import com.entanmo.etmall.db.service.EtmallGoodsService;
import com.entanmo.etmall.db.service.EtmallOrderService;
import com.entanmo.etmall.db.service.EtmallUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/dashboard")
@Validated
public class AdminDashbordController {
    private final Log logger = LogFactory.getLog(AdminDashbordController.class);

    @Autowired
    private EtmallUserService userService;
    @Autowired
    private EtmallGoodsService goodsService;
    @Autowired
    private EtmallGoodsProductService productService;
    @Autowired
    private EtmallOrderService orderService;

    @GetMapping("")
    public Object info() {
        int userTotal = userService.count();
        int goodsTotal = goodsService.count();
        int productTotal = productService.count();
        int orderTotal = orderService.count();
        Map<String, Integer> data = new HashMap<>();
        data.put("userTotal", userTotal);
        data.put("goodsTotal", goodsTotal);
        data.put("productTotal", productTotal);
        data.put("orderTotal", orderTotal);

        return ResponseUtil.ok(data);
    }

}
