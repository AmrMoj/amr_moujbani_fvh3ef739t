package com.anywr.amrmoujbanifvh3ef739m.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Before("execution(* com.anywr.amrmoujbanifvh3ef739m.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Executing method " + " : " +name);
    }

    @After("execution(* com.anywr.amrmoujbanifvh3ef739m.service.*.*(..))")
    public void logAfter(JoinPoint point) {
        log.info("The method "+point.getSignature().getName() + " is called ...");
    }

    @AfterReturning(value = "execution(* com.anywr.amrmoujbanifvh3ef739m.service.*.*(..))",
            returning = "retVal")
    public void afterReturningAdvice(JoinPoint jp, Object retVal){
        if (retVal!=null)
            log.info("Method : "  + jp.getSignature().getName()+" Returning: "
                    + retVal.getClass().getSimpleName());
    }
}

