package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.api.user.annotation.LoginUser;
import com.entanmo.etmall.core.util.RegexUtil;
import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.db.domain.EtmallAddress;
import com.entanmo.etmall.db.service.EtmallAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/user/address")
@Validated
public class AddressController {

    @Autowired
    private EtmallAddressService addressService;


    private Object validate(EtmallAddress address) {
        String name = address.getName();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.badArgument();
        }

        // 测试收货手机号码是否正确
        String mobile = address.getTel();
        if (StringUtils.isEmpty(mobile)) {
            return ResponseUtil.badArgument();
        }
        if (!RegexUtil.isMobileExact(mobile)) {
            return ResponseUtil.badArgument();
        }

        String province = address.getProvince();
        if (StringUtils.isEmpty(province)) {
            return ResponseUtil.badArgument();
        }

        String city = address.getCity();
        if (StringUtils.isEmpty(city)) {
            return ResponseUtil.badArgument();
        }

        String county = address.getCounty();
        if (StringUtils.isEmpty(county)) {
            return ResponseUtil.badArgument();
        }


        String areaCode = address.getAreaCode();
        if (StringUtils.isEmpty(areaCode)) {
            return ResponseUtil.badArgument();
        }

        String detailedAddress = address.getAddressDetail();
        if (StringUtils.isEmpty(detailedAddress)) {
            return ResponseUtil.badArgument();
        }

        Boolean isDefault = address.getDefault();
        if (isDefault == null) {
            return ResponseUtil.badArgument();
        }
        return null;
    }


    // 收货地址列表
    @GetMapping("list")
    public Object list(@LoginUser Integer userId){
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        List<EtmallAddress> addressList = addressService.queryByUid(userId);
        return ResponseUtil.okList(addressList);
    }

    // 收货地址详情
    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, @NotNull Integer id){
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        EtmallAddress address = addressService.query(userId, id);
        if (address == null) {
            return ResponseUtil.badArgumentValue();
        }
        return ResponseUtil.ok(address);
    }

    // 添加或更新收货地址
    @GetMapping("save")
    public Object save(@LoginUser Integer userId, @RequestBody EtmallAddress address){
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Object error = validate(address);
        if (error != null) {
            return error;
        }

        if (address.getDefault()) {
            // 重置其他收获地址的默认选项
            addressService.resetDefault(userId);
        }

        if (address.getId() == null || address.getId().equals(0)) {
            address.setId(null);
            address.setUserId(userId);
            addressService.add(address);
        } else {
            address.setUserId(userId);
            if (addressService.update(address) == 0) {
                return ResponseUtil.updatedDataFailed();
            }
        }
        return ResponseUtil.ok(address.getId());
    }

    // 删除收货地址
    @GetMapping("delete")
    public Object delete(@LoginUser Integer userId, @RequestBody EtmallAddress address){
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Integer id = address.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }

        addressService.delete(id);
        return ResponseUtil.ok();
    }

}
