package com.entanmo.etmall.core.service;

import com.entanmo.etmall.db.constant.CouponConstant;
import com.entanmo.etmall.db.domain.EtmallCoupon;
import com.entanmo.etmall.db.domain.EtmallCouponUser;
import com.entanmo.etmall.db.service.EtmallCouponService;
import com.entanmo.etmall.db.service.EtmallCouponUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponAssignService {

//    @Autowired
    private EtmallCouponUserService couponUserService;
//    @Autowired
    private EtmallCouponService couponService;

    /**
     * 分发注册优惠券
     */
    public void assignForRegister(Integer userId) {
        List<EtmallCoupon> couponList = couponService.queryRegister();
        for(EtmallCoupon coupon : couponList){
            Integer couponId = coupon.getId();

            Integer count = couponUserService.countUserAndCoupon(userId, couponId);
            if (count > 0) {
                continue;
            }

            Short limit = coupon.getLimit();
            while(limit > 0){
                EtmallCouponUser couponUser = new EtmallCouponUser();
                couponUser.setCouponId(couponId);
                couponUser.setUserId(userId);
                Short timeType = coupon.getTimeType();
                if (timeType.equals(CouponConstant.TIME_TYPE_TIME)) {
                    couponUser.setStartTime(coupon.getStartTime());
                    couponUser.setEndTime(coupon.getEndTime());
                }
                else{
                    LocalDateTime now = LocalDateTime.now();
                    couponUser.setStartTime(now);
                    couponUser.setEndTime(now.plusDays(coupon.getDays()));
                }
                couponUserService.add(couponUser);

                limit--;
            }
        }

    }
}
