//package com.codility.external;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//
//import org.springframework.context.annotation.Configuration;
//
//@Aspect
//@Configuration
//public class StringManipulationAspect {
//
//    public static final Logger log = LoggerFactory.getLogger(StringManipulationAspect.class);
//
//    // 1번
//    @Before("com.codility.external.StringManipulationService")
//    public static void setup() {
//        log.info("Method execution started");
//    }
//
//    // 2번
//    @AfterReturning(value = "com.codility.external.StringManipulationService.capitalizeAllLetters()",
//            returning = "result")
//    public void afterReturning() {
//        log.info("Finished successfully");
//    }
//
//    @Around("com.codility.external.StringManipulationService.removeAllWhitespaces()")
//    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        proceedingJoinPoint.proceed();
//        long timeTaken = System.currentTimeMillis() - startTime;
//        log.info("Duration in milliseconds: {}", timeTaken);
//    }
//
//    @AfterThrowing(value = "com.codility.external.StringManipulationService.removeAllNumbers()()",
//            throwing = "IllegalStateException")
//    public void afterThrowing(JoinPoint joinpoint, Exception exception) {
//        log.error("{} return with value {}", joinpoint, exception);
//    }
//}
