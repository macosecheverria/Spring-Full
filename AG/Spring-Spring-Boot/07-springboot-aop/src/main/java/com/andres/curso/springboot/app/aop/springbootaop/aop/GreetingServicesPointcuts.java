package com.andres.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicesPointcuts {

    @Pointcut("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void greetingLoggerPoincut() {
    }

    @Pointcut("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
    public void greetingFooLoggerPointcut() {
    }
}
