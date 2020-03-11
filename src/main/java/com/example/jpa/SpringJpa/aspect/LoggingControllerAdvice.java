package com.example.jpa.SpringJpa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.persistence.JoinTable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@Aspect
@Component
public class LoggingControllerAdvice {
    @Before("userControllerPointCut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("--BEFORE-- Méthode : " + joinPoint.getSignature().getName()+"()"
        + "invoqué avec :"+ Arrays.toString(joinPoint.getArgs()));

    }
//    @After("execution(* com.example.jpa.SpringJpa.mvc.*.*(..))")
//    public void logAfter(JoinPoint joinPoint, Object returnValue){
//
//        System.out.println("--After--: Methode "+ joinPoint.getSignature().getName() + "() et a retourné la valeur :" + returnValue);
//    }
    @Around("userControllerPointCut()")
    public Object logExecutTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch watch= new StopWatch();
        watch.start();
        Object proceed =proceedingJoinPoint.proceed();
        watch.stop();
        System.out.println("--After--: Méthode "+ proceedingJoinPoint.getSignature() + "exécutée en " + watch.getTotalTimeMillis() +" ms" );

        return proceed;
    }

    @AfterThrowing(pointcut ="userControllerPointCut()", throwing = "e")
    public void logThrowAllMethod(JoinPoint joinPoint, Exception e) throws Throwable{
        System.out.println("---Exception--- Method " + joinPoint.getSignature().getName());
        System.out.println("---Exception details--- Method " + e.getMessage());
    }


    @Pointcut("execution(* com.example.jpa.SpringJpa.mvc.UserMvcController.*(..))")
    public void userControllerPointCut(){}
}
