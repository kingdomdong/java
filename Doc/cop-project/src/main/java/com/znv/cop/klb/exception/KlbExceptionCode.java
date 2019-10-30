package com.znv.cop.klb.exception;

/**
 * KLB系统异常码定义类，定义不同流程的异常码，为6位数字
 * @author nieguigui
 * @version v0.01
 * @since 2018-08-13
 */
public enum KlbExceptionCode {

    INTERNAL_ERROR(100001, "系统内部异常");

    private int code;

    private String message;

    KlbExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String mapMessage(int code) {
        String message = "";
        for (KlbExceptionCode name : values()) {
            if (code == name.getCode()) {
                message = name.getMessage();
                break;
            }
        }

        return message;
    }
}
