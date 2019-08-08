package com.entanmo.etmall.core.vo;

/**
 * 发送短信的返回结果
 */
public class SmsResultVo {

    private boolean successful;
    private Object result;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
