package com.andres.curso.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Before("execution(String
    // com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    // @Before("execution(*
    // com.andres.curso.springboot.app.aop.springbootaop..*.*(..))")
    @Before("GreetingServicesPointcuts.greetingLoggerPoincut()")
    public void loggerBefore(JoinPoint point) {

        String method = point.getSignature().getName();
        String args = Arrays.toString(point.getArgs());

        logger.info("Antes: " + method + " con los argumentos: " + args);
    }

    @After("GreetingServicesPointcuts.greetingLoggerPoincut()")
    public void loggerAfter(JoinPoint point) {
        String method = point.getSignature().getName();
        String args = Arrays.toString(point.getArgs());

        logger.info("Despues: " + method + " con los argumentos: " + args);
    }

    @AfterReturning("GreetingServicesPointcuts.greetingLoggerPoincut()")
    public void loggerAfterReturning(JoinPoint point) {
        String method = point.getSignature().getName();
        String args = Arrays.toString(point.getArgs());

        logger.info("Despues de retornar: " + method + " con los argumentos: " + args);
    }

    @AfterThrowing("GreetingServicesPointcuts.greetingLoggerPoincut()")
    public void loggerAfterThrowing(JoinPoint point) {
        String method = point.getSignature().getName();
        String args = Arrays.toString(point.getArgs());

        logger.info("Despues de lanzar la excepcion: " + method + " con los argumentos: " + args);
    }

    @Around("GreetingServicesPointcuts.greetingLoggerPoincut()")
    public Object loogerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;

        try {

            logger.info("El metodo " + method + "() con los parametros " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "( ) retorna el resultado" + result);

            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo" + method + "()");
            throw e;
        }
    }
}
