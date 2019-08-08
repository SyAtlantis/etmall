package com.entanmo.etmall.core.service;

import com.entanmo.etmall.core.vo.UserVo;
import com.entanmo.etmall.db.domain.EtmallUser;
import com.entanmo.etmall.db.service.EtmallUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private EtmallUserService userService;

    public UserVo findUserVoById(Integer userId) {
        EtmallUser user = userService.findById(userId);
        UserVo userVo = new UserVo();
        userVo.setNickname(user.getNickname());
        userVo.setAvatar(user.getAvatar());
        return userVo;
    }
}
