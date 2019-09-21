package com.king.base;

public class Response {
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
    private String msg = "";

    /**
     * 返回的具体数据
     */
    private Object data;

    public Response() {

    }

    public Response(Exception exception) {
        this.success = Boolean.FALSE;
        this.errCode = -1;
        this.msg = exception.getMessage();
    }

    public Response(Object data) {
        this.data = data;
    }

    public Response(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public Response(Object data, Integer errorCode, String msg) {
        this.data = data;
        this.msg = msg;
        this.errCode = errorCode;
        if(errorCode == null || errorCode != 0)
        {
        	this.success = Boolean.FALSE;
        }
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isResponseSuccess() {
        if (this.errCode == 0) {
            return Boolean.TRUE;
        }
        
        return Boolean.FALSE;
    }
}