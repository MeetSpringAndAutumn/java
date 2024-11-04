package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 生成新类/接口/枚举
 *
 * @Author: shanzhengshuai
 * @Description:计算时间
 * @Date: 2024/10/31
 */

@Component
@Aspect
@Slf4j
public class Aop1 {
    final String s="execution(* com.example.service.impl.*.*(..))";
    @Pointcut("execution(* com.example.service.impl.*.*(..))")

//    @Pointcut("@annotation()")方法二：基于注解
    public void pointcut(){}
    @Around(s)
    public Object recordTime(ProceedingJoinPoint joinPoint){
        Long begin=System.currentTimeMillis();
        Object result;
        try {
             result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        Long end=System.currentTimeMillis();
        log.info("{}执行耗时{}ms",joinPoint.getSignature().getDeclaringTypeName(),end-begin);
        return result;
    }
}
