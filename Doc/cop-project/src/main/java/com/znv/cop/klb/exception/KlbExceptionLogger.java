package com.znv.cop.klb.exception;

import com.znv.cop.klb.common.Consts;
import com.znv.cop.klb.util.DateUtils;
import com.znv.cop.klb.util.Logger;
import com.znv.cop.klb.vo.SysExceptionLogVo;

public class KlbExceptionLogger {

    public static void print(Throwable e) {

        String clazzName = "";
        String methodName = "";
        StackTraceElement[] st = e.getStackTrace();
        for (StackTraceElement stackTraceElement : st) {
            String exclass = stackTraceElement.getClassName();
            if (exclass.contains("com.znv.cop")) {
                clazzName = stackTraceElement.getClassName();
                methodName = stackTraceElement.getMethodName();
                break;
            }
        }

        //日志中记录原始的异常信息
        LlbException ex = null;
        if (e instanceof LlbException) {
            ex = (LlbException) e;

        } else {
            ex = new LlbException(e);
        }

        //记录异常日志
        SysExceptionLogVo log = new SysExceptionLogVo();
        log.setServiceCode(Consts.SERVICE_CODE);
        log.setClazzName(clazzName);
        log.setFuncName(methodName);
        log.setErrCode(String.valueOf(ex.getCode()));
        log.setErrDesc(ex.getMessage());
        log.setTime(DateUtils.getDateTime());
        Logger.jsonInfo(log);
    }
}
