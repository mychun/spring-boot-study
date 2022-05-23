package com.chun.springbootstudy.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//使这个类成为切面类
@Aspect
@Component
@Slf4j
public class LogAop {
    @Pointcut("execution(public * com.chun.*.controller.*.*(..))")
    public void logger(){}

    @Around("logger()")
    public Object doAround(ProceedingJoinPoint point){
        Signature methodName = point.getSignature();
        log.info(methodName + "进来了");

        Object obj = null;
        Long startTime = System.currentTimeMillis();
        try {
            obj = point.proceed(point.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();
        log.info(methodName + "方法走了/t耗时：" + (endTime - startTime));
        return obj;
    }
}
