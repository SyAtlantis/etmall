package com.entanmo.etmall.core.dao;

import com.entanmo.etmall.core.vo.SmsResultVo;

public interface ISmsSender {

    /**
     * 发送短信息
     *
     * @param phone   接收通知的电话号码
     * @param content 短消息内容
     */
    SmsResultVo send(String phone, String content);


    /**
     * 通过短信模版发送短信息
     *
     * @param phone      接收通知的电话号码
     * @param templateId 通知模板ID
     * @param params     通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    SmsResultVo sendWithTemplate(String phone, int templateId, String[] params);
}