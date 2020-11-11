package com.znv.peim.bpm.common.intercepter;

import com.znv.peim.bpm.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Http request parameters log
 *
 * @author Yum
 * @version 1.0
 * @since 2020-08-26 10:00:27
 */
@Slf4j
@Aspect
@Component
public class RequestLogAspect {

    private static final ThreadLocal<Long> startTime = new ThreadLocal<>();

    private static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    @Pointcut("execution(public * com.znv.peim.bpm.controller..*(..))")
    public void requestLog() {
    }

    @Before("requestLog()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            startTime.set(System.currentTimeMillis());
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                HttpServletRequest request = requestAttributes.getRequest();
                log.info("\n\trequest IP: {}\n\trequest URL: {}\n\trequest METHOD: {}\n\trequest CLASS_METHOD: {}\n\trequest ARGS: {}",
                        getIP(request),
                        request.getRequestURL(),
                        request.getMethod(),
                        joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                        JSONUtils.jsonString(joinPoint.getArgs()));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @AfterReturning(pointcut = "requestLog()")
    public void doAfter() {
        log.info("request TIME: {} msecs", System.currentTimeMillis() - startTime.get());
    }

}