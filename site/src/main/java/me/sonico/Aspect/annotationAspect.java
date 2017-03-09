package me.sonico.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import me.sonico.utils.Log;

/**
 * @author Jack
 * @time 2016/11/27 0027 22:15
 * @des TODO
 */

@Aspect
public class annotationAspect {
    @Autowired
    private Log log;
    @Pointcut(value="execution(* me.sonico.Controller..*.*(..))")
    public void 只是切面的载体但并没有什么卵用的方法(){}

   @Before(value = "只是切面的载体但并没有什么卵用的方法()")
    public void beforePointcut(){
        System.out.println("=====before");
    }

    @After(value = "只是切面的载体但并没有什么卵用的方法()")
    public void afterPointcut(){
        System.out.println("=====after");
    }
    @AfterReturning(value = "只是切面的载体但并没有什么卵用的方法()",
    argNames = "returnVal",returning = "returnVal"
    )
    public void afterReturn(Object returnVal){
        System.out.println("=====afterReturn the return Obj = "+returnVal);
    }
//    @AfterThrowing

    //可以定义多个环绕通知  http://jinnianshilongnian.iteye.com/blog/1418598
    @Around(value = "只是切面的载体但并没有什么卵用的方法()" )
    public void aroundPointcut(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        joinPoint.getArgs();
        System.err.println("the args == "+ Arrays.asList(joinPoint.getArgs()));
        log.i("fortest","the args == "+ Arrays.asList(joinPoint.getArgs()));
//        try {
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
        long end = System.currentTimeMillis();
        String methodname = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        System.err.println("the method = "+methodname+" start = "+start+" end = "+end+" detail = "+(end-start));
    }
}
