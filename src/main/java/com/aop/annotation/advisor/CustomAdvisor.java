package com.aop.annotation.advisor;

import com.aop.annotation.anno.Custom;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class CustomAdvisor {
    // 어노테이션을 이용하여 pointcut 등록
    @Around("@annotation(com.aop.annotation.anno.Custom)")
    public Object processCustomAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Custom custom = methodSignature.getMethod().getAnnotation(Custom.class);
        log.info("execute custom annotation processing with annotation param = {}, {}", custom.firstValue(), custom.secondValue());
        log.info("(어노테이션 이용)Before invoke getSomeValue()");
        Object proceedReturnValue = proceedingJoinPoint.proceed();
        log.info("(어노테이션 이용)After invoke getSomeValue(): {}", proceedReturnValue);
        return proceedReturnValue;
    }

    @Around("within(com.aop.annotation.service.*)")
    public Object logForTarget(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("(pointcut 이용)Before invoke target()");
        Object result = joinPoint.proceed();
        log.info("(pointcut 이용)After invoke target(): {}", result);
        return result;
    }
}
