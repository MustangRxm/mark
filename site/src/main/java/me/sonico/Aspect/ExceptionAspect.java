package me.sonico.Aspect;

/**
 * 说明：
 *     切面的通知是处理异常的，而这个异常处理是完全独立于系统之外的内容
 * @author zd
 *
 */
//@Aspect
public class ExceptionAspect {

//	public void throwingExcetion(JoinPoint joinPoint){
////		System.out.println(ex.getMessage());
//		System.err.println("__________________________________test_________________________________");
//	}
//	@Pointcut("execution(* me.sonico.logic..*.*(..))")
	int i =0;
	public void throwingExcetion(){
//		System.out.println(ex.getMessage());
		System.err.println("__________________________________test_________________________________");
	}

//	@Before("throwingExcetion()")
	public void beforePrint(){
		i++;
		System.err.println("_______________________before____________________________");
	}

//	@After("throwingExcetion()")
	public void afterPrint(){
		i++;
		System.err.println("_______________________after____________________________");
	}
	public void afterReturnPrint(){
		System.err.println("i == "+i);
		System.err.println("_______________________afterReturn____________________________");
	}
	public void aroundPrint(){
		System.err.println("_______________________aroundFinal____________________________");
	}
}
