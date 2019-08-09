package com.entanmo.etmall.core.service;

import com.entanmo.etmall.core.vo.UserInfoVo;
import com.entanmo.etmall.db.domain.EtmallUser;
import com.entanmo.etmall.db.service.EtmallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {

    @Autowired
    private EtmallUserService userService;

    public UserInfoVo getInfo(Integer userId) {
        EtmallUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfoVo userInfo = new UserInfoVo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
