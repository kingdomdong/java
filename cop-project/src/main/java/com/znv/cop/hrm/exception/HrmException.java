package com.znv.cop.hrm.exception;

import com.znv.cop.hrm.util.StringUtils;

/**
 * DTL系统统一异常定义类，统一规划系统异常
 * @author nieguigui
 * @version v0.0.1
 * @since 2018-08-13
 */
public class HrmException extends RuntimeException {

    private static final long serialVersionUID = -6034324836011469058L;

    private HrmExceptionCode exceptionCode;

    public HrmException() {
        super();
        this.exceptionCode = HrmExceptionCode.INTERNAL_ERROR;
    }

    public HrmException(String message) {
        super(message);
        this.exceptionCode = HrmExceptionCode.INTERNAL_ERROR;
    }

    public HrmException(HrmExceptionCode code) {
        super();
        this.exceptionCode = code;
    }

    public HrmException(Throwable cause) {
        super(cause);
        this.exceptionCode = HrmExceptionCode.INTERNAL_ERROR;
    }

    public HrmException(HrmExceptionCode code, Throwable cause) {
        super(cause);
        this.exceptionCode = code;
    }

    public int getCode() {
        return exceptionCode.getCode();
    }

    @Override
    public String getMessage() {
        if (StringUtils.isEmpty(exceptionCode.getMessage())) {
            return super.getMessage();
        } else {
            return exceptionCode.getMessage();
        }
    }

}
