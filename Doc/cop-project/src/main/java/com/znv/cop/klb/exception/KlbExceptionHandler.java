package com.znv.cop.klb.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.znv.cop.klb.common.Consts;
import com.znv.cop.klb.result.vo.JsonResult;
import com.znv.cop.klb.util.DateUtils;
import com.znv.cop.klb.util.Logger;
import com.znv.cop.klb.vo.SysExceptionLogVo;

/**
 * KLB系统异常处理器，统一捕获Controller抛出的异常，并返回前端
 * @author nieguigui
 * @version v0.01
 * @since 2018-08-13
 */
@RestControllerAdvice
public class KlbExceptionHandler {

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public String resolveException(Exception e, HttpServletRequest request) {

        //日志中记录原始的异常信息，而后经过包装返回前端
        LlbException ex = null;
        if (e instanceof LlbException) {
            ex = (LlbException) e;

        } else {
            ex = new LlbException(e);
        }
        Logger.e(ex);

        //记录异常日志
        SysExceptionLogVo log = new SysExceptionLogVo();
        log.setServiceCode(Consts.SERVICE_CODE);
        log.setClazzName(e.getStackTrace()[0].getClassName());
        log.setFuncName(e.getStackTrace()[0].getMethodName());
        log.setErrCode(String.valueOf(ex.getCode()));
        log.setErrDesc(ex.getMessage());
        log.setTime(DateUtils.getDateTime());
        Logger.jsonInfo(log);

        JsonResult result = new JsonResult();
        result.setCode(ex.getCode());
        result.setMessage(ex.getMessage());

        return result.toJSON();
    }
}
