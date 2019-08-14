package com.entanmo.etmall.api.admin.job;

import com.entanmo.etmall.db.constant.CouponConstant;
import com.entanmo.etmall.db.constant.CouponUserConstant;
import com.entanmo.etmall.db.domain.EtmallCoupon;
import com.entanmo.etmall.db.domain.EtmallCouponUser;
import com.entanmo.etmall.db.service.EtmallCouponService;
import com.entanmo.etmall.db.service.EtmallCouponUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 检测优惠券过期情况
 */
@Component
public class CouponJob {
    private final Log logger = LogFactory.getLog(CouponJob.class);

    @Autowired
    private EtmallCouponService couponService;

    @Autowired
    private EtmallCouponUserService couponUserService;

    /**
     * 每隔一个小时检查
     * TODO
     * 注意，因为是相隔一个小时检查，因此导致优惠券真正超时时间可能比设定时间延迟1个小时
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    public void checkCouponExpired() {
        logger.info("系统开启任务检查优惠券是否已经过期");

        List<EtmallCoupon> couponList = couponService.queryExpired();
        for (EtmallCoupon coupon : couponList) {
            coupon.setStatus(CouponConstant.STATUS_EXPIRED);
            couponService.updateById(coupon);
        }

        List<EtmallCouponUser> couponUserList = couponUserService.queryExpired();
        for (EtmallCouponUser couponUser : couponUserList) {
            couponUser.setStatus(CouponUserConstant.STATUS_EXPIRED);
            couponUserService.update(couponUser);
        }
    }

}
