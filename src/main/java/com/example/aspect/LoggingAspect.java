package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before Aspect ---- Before Advice
    @Before("execution(* com.example.service.UserService.addUser(..))")
    public void beforeAddUser() {
        System.out.println("Before adding user.");
    }

    //After Aspect ----- After Advice
    @After("execution(* com.example.service.UserService.addUser(..))")
    public void afterAddUser() {
        System.out.println("After adding user.");
    }

    @Before("execution(* com.example.service.UserService.deleteUser(..))")
    public void beforeDeleteUser() {
        System.out.println("Before deleting user.");
    }

    @After("execution(* com.example.service.UserService.deleteUser(..))")
    public void afterDeleteUser() {
        System.out.println("After deleting user.");
    }

    // After Returning Advice
    @AfterReturning(pointcut = "execution(* com.example.service.UserService.getUser(..))", returning = "result")
    public void afterReturningGetUser(Object result) {
        System.out.println("After returning from getUser. Result: " + result);
    }

    //After Throwing Advice
    @AfterThrowing(pointcut = "execution(* com.example.service.UserService.deleteUser(..))", throwing = "exception")
    public void afterThrowingDeleteUser(Exception exception) {
        System.out.println("After throwing from deleteUser. Exception: " + exception.getMessage());
    }

    //Around Advice
    @Around("execution(* com.example.service.UserService.getUser(..))")
    public Object aroundGetUser(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before proceeding with getUser.");
        Object result = joinPoint.proceed();
        System.out.println("After proceeding with getUser.");
        return result;
    }

    //Pointcut
    @Pointcut("exection(* com.example..*(..))")
    public void allMethods(){
        System.out.println("All Methods.");
    }
}

