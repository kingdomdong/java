package com.znv.cop.hrm.exception;

import com.znv.cop.hrm.common.Consts;
import com.znv.cop.hrm.util.DateUtils;
import com.znv.cop.hrm.util.Logger;
import com.znv.cop.hrm.vo.SysExceptionLogVo;

public class HrmExceptionLogger {

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
        HrmException ex = null;
        if (e instanceof HrmException) {
            ex = (HrmException) e;

        } else {
            ex = new HrmException(e);
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
