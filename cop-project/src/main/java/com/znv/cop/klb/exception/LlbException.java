package com.znv.cop.klb.exception;

import com.znv.cop.klb.util.StringUtils;

/**
 * KLB系统统一异常定义类，统一规划系统异常
 * @author nieguigui
 * @version v0.0.1
 * @since 2018-08-13
 */
public class LlbException extends RuntimeException {

    private static final long serialVersionUID = -6034324836011469058L;

    private KlbExceptionCode exceptionCode;

    public LlbException() {
        super();
        this.exceptionCode = KlbExceptionCode.INTERNAL_ERROR;
    }

    public LlbException(String message) {
        super(message);
        this.exceptionCode = KlbExceptionCode.INTERNAL_ERROR;
    }

    public LlbException(KlbExceptionCode code) {
        super();
        this.exceptionCode = code;
    }

    public LlbException(Throwable cause) {
        super(cause);
        this.exceptionCode = KlbExceptionCode.INTERNAL_ERROR;
    }

    public LlbException(KlbExceptionCode code, Throwable cause) {
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
