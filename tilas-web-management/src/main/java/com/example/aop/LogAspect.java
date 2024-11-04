package com.example.aop;

import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 生成新类/接口/枚举
 *
 * @Author: shanzhengshuai
 * @Description:
 * @Date: 2024/11/1
 */

@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    OperateLogMapper operateLogMapper;
    @Autowired
    HttpServletRequest request;

    @Around("@annotation(com.example.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(token);
        Integer operateUserId = (Integer) claims.get("id");
        LocalDateTime operateTime = LocalDateTime.now();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String methodParams = joinPoint.getArgs().toString();
        Long begin = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long costTime = end - begin;
        OperateLog operateLog = new OperateLog(null, operateUserId, operateTime, className, methodName, methodParams, returnValue.toString(), costTime);
        operateLogMapper.insert(operateLog);
        return returnValue;
    }
}
