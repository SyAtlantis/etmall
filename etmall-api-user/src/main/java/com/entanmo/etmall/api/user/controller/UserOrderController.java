package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.api.user.annotation.LoginUser;
import com.entanmo.etmall.core.service.UserOrderService;
import com.entanmo.etmall.core.validator.Order;
import com.entanmo.etmall.core.validator.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * 订单服务
 */
@RestController
@RequestMapping("/user/order")
@Validated
public class UserOrderController {

    private UserOrderService userOrderService;

    /**
     * 订单列表
     */
    @GetMapping("list")
    public Object list(@LoginUser Integer userId,
                       @RequestParam(defaultValue = "0") Integer showType,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        return userOrderService.list(userId, showType, page, limit, sort, order);
    }

    /**
     * 订单详情
     */
    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, @NotNull Integer orderId) {
        return userOrderService.detail(userId, orderId);
    }

    /**
     * 提交订单
     * 订单信息，{ cartId：xxx, addressId: xxx, couponId: xxx, message: xxx, grouponRulesId: xxx,  grouponLinkId: xxx}
     */
    @PostMapping("submit")
    public Object submit(@LoginUser Integer userId, @RequestBody String body) {
        return userOrderService.submit(userId, body);
    }

    /**
     * 取消订单
     */
    @PostMapping("cancel")
    public Object cancel(@LoginUser Integer userId, @RequestBody String body) {
        return userOrderService.cancel(userId, body);
    }

    /**
     * 付款订单的预支付会话标识
     */
    @PostMapping("prepay")
    public Object prepay(@LoginUser Integer userId, @RequestBody String body, HttpServletRequest request) {
        return userOrderService.prepay(userId, body, request);
    }

    /**
     * 微信付款成功或失败回调接口
     * <p>
     *  TODO
     *  注意，这里pay-notify是示例地址，建议开发者应该设立一个隐蔽的回调地址
     */
    @PostMapping("pay-notify")
    public Object payNotify(HttpServletRequest request, HttpServletResponse response) {
        return userOrderService.payNotify(request, response);
    }

    /**
     * 订单申请退款
     */
    @PostMapping("refund")
    public Object refund(@LoginUser Integer userId, @RequestBody String body) {
        return userOrderService.refund(userId, body);
    }

    /**
     * 确认收货
     */
    @PostMapping("confirm")
    public Object confirm(@LoginUser Integer userId, @RequestBody String body) {
        return userOrderService.confirm(userId, body);
    }

    /**
     * 删除订单
     */
    @PostMapping("delete")
    public Object delete(@LoginUser Integer userId, @RequestBody String body) {
        return userOrderService.delete(userId, body);
    }

    /**
     * 待评价订单商品信息
     */
    @GetMapping("goods")
    public Object goods(@LoginUser Integer userId,
                        @NotNull Integer orderId,
                        @NotNull Integer goodsId) {
        return userOrderService.goods(userId, orderId, goodsId);
    }

    /**
     * 评价订单商品
     */
    @PostMapping("comment")
    public Object comment(@LoginUser Integer userId, @RequestBody String body) {
        return userOrderService.comment(userId, body);
    }

}
