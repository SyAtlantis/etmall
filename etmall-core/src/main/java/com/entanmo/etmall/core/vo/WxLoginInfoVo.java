package com.entanmo.etmall.core.vo;

public class WxLoginInfoVo {

    private String code;
    private UserInfoVo userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfoVo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoVo userInfo) {
        this.userInfo = userInfo;
    }
}
