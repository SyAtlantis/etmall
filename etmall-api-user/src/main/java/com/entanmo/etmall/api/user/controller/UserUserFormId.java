package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.api.user.annotation.LoginUser;
import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.db.domain.EtmallUser;
import com.entanmo.etmall.db.domain.EtmallUserFormid;
import com.entanmo.etmall.db.service.EtmallUserFormIdService;
import com.entanmo.etmall.db.service.EtmallUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/user/formid")
@Validated
public class UserUserFormId {

    @Autowired
    private EtmallUserService userService;

    @Autowired
    private EtmallUserFormIdService formIdService;

    @GetMapping("create")
    public Object create(@LoginUser Integer userId, @NotNull String formId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        EtmallUser user = userService.findById(userId);
        EtmallUserFormid userFormid = new EtmallUserFormid();
        userFormid.setOpenid(user.getOpenid());
        userFormid.setFormid(formId);
        userFormid.setIsprepay(false);
        userFormid.setUseamount(1);
        userFormid.setExpireTime(LocalDateTime.now().plusDays(7));
        formIdService.addUserFormid(userFormid);

        return ResponseUtil.ok();
    }
}
