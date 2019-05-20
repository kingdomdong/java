package com.znv.cop.hrm.result.vo;

public class ResponseVO<T> {

    /**
     * 成功标记
     */
    private boolean success = true;

    /**
     * 错误码
     */
    private int errCode;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回的具体数据
     */
    private T data;

    public ResponseVO() {

    }

    public boolean isResponseSuccess() {
        if (this.errCode == 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}