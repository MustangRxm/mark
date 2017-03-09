package me.sonico.Aspect;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import me.sonico.bean.TArticle;
import me.sonico.utils.Log;

/**
 * Created by yanfa_4 on 2016-11-19.
 */
@Aspect
public class LogAspect {
    @Autowired
    private Log log;

    private Gson gson  = new Gson();

//    @Pointcut(value="execution(* (me.sonico.Controller+ && me.sonico.logic+).*(..))")
//@Pointcut(value="execution(* me.sonico.Controller..*.*(..))")
//    @Pointcut(value = "execution(* (me.sonico.Controller.* || me.sonico.logic.*).*(..))")
    @Pointcut(value = "execution(* ( me.sonico.logic.*).*(..))")
    public void LogicLogApectPointCut(){}

    //2
    @Before(value="LogicLogApectPointCut()")
    public void before(JoinPoint pj){
        log.i(0l,pj.getSignature().getDeclaringTypeName(),pj.getSignature().getName(),"开始执行",Arrays.asList(pj.getArgs()).toString());
//        log.i("test","entry method aspect");
    }

    //5
    @After(value="LogicLogApectPointCut()")
    public void after(JoinPoint joinPoint){
//        log.i("test","leave method aspect");
        log.e("exception",Arrays.asList(joinPoint.getArgs()).toString());

    }

    //6
    @AfterReturning(value = "LogicLogApectPointCut()")
    public void afterReturn(JoinPoint joinPoint){
        log.i("test",Arrays.asList(joinPoint.getArgs()).toString());
    }
    @AfterThrowing(value = "LogicLogApectPointCut()",  argNames="ex", throwing="ex")
//    public void afterThrowing(DataAccessException ex){
    public Optional afterThrowing(Exception ex){
//        log.i("test","afterThrowing");
//        ex.printStackTrace();
        return Optional.of(Lists.newArrayList().add(new TArticle()));
    }

    //1
    @Around(value = "LogicLogApectPointCut()")
    public Object around(ProceedingJoinPoint pj)  {
    long start = System.currentTimeMillis();
        //3
        log.i(0l,pj.getSignature().getDeclaringTypeName(),pj.getSignature().getName(),"开始执行",Arrays.asList(pj.getArgs()).toString());
        Optional obj = null;
       int i = Integer.parseInt( pj.getArgs()[0].toString());
        try {
            obj = (Optional) pj.proceed(new Object[]{3});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            TArticle at= new TArticle();
            at.setArticleTitle("fdsfsdf");
            at.setArticleId(1234l);
            at.setArticleStatus(false);
            List list = Lists.newArrayList();
            list.add(at);
            obj =  Optional.of(list);
        }finally{
            long stop = System.currentTimeMillis();
            log.i(0l,pj.getSignature().getDeclaringTypeName(),pj.getSignature().getName(),"执行完毕",gson.toJson(obj),(stop-start));
            return obj;
        }
//        pj.proceed();


        //4

    }
}
