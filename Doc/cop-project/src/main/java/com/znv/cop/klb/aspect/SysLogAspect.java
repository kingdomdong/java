package com.znv.cop.klb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.znv.cop.klb.common.Consts;
import com.znv.cop.klb.exception.KlbExceptionLogger;
import com.znv.cop.klb.util.DateUtils;
import com.znv.cop.klb.util.Logger;
import com.znv.cop.klb.vo.BusinessActionLogVo;
import com.znv.cop.klb.vo.InterfaceLogVo;

@Aspect
@Component
public class SysLogAspect {

    @Pointcut("execution(* com..*.IAction.act())")
    public void businessLog() {

    }

    @Pointcut("execution(* com..*.controller.**.*(..))")
    public void interfaceLog() {

    }

    @Pointcut("execution(* com..*.IAction.*(..))")
    public void errorLog() {

    }

    @Around(value = "businessLog()")
    public Object doBusinessLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //记录节点业务日志
        BusinessActionLogVo logVo = new BusinessActionLogVo();
        String action = joinPoint.getSignature().getName();;
        logVo.setAction(action);
        logVo.setTarget(action);
        logVo.setTime(DateUtils.getDateTime());
        logVo.setDuration(end - begin);
        logVo.setServiceCode(Consts.SERVICE_CODE);
        logVo.setIsComplete(Consts.COMPLETED);
        Logger.jsonInfo(logVo);

        return object;
    }

    @Around(value = "interfaceLog()")
    public Object doInterfaceLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //记录接口调用日志
        InterfaceLogVo logVo = new InterfaceLogVo();
        logVo.setServiceCode(Consts.SERVICE_CODE);
        logVo.setServiceName(Consts.SERVICE_NAME);
        logVo.setApiName(
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logVo.setTime(DateUtils.getDateTime());
        logVo.setDuration(end - begin);
        Logger.jsonInfo(logVo);

        return object;
    }

    @AfterThrowing(value = "errorLog()", throwing = "e")
    public void doErrorLog(JoinPoint joinPoint, Throwable e) {
        KlbExceptionLogger.print(e);
    }
}
