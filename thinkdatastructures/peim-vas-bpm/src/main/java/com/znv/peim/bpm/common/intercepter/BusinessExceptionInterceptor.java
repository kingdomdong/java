package com.znv.peim.bpm.common.intercepter;

import com.znv.peim.bpm.common.exception.BusinessException;
import com.znv.peim.bpm.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Business exception handler
 *
 * @author Yum
 * @version 1.0
 * @since 2020-08-21 09:53:51
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.znv")
public class BusinessExceptionInterceptor {

    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return Result.error(e);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MethodArgumentNotValidException.class})
    public Result<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage(), e);
        return Result.error(HttpStatus.BAD_REQUEST.value(), "method arguments error");
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public Result<?> handleBaseException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.toString());
    }

}
