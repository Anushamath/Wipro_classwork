package aopdemo.Aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	
	@Before("execution(* aopdemo.Aop.ShoppingCart.checkout(..))")
	public void beforeLogger(JoinPoint jb)
	{
		System.out.println("Loggers "+jb.getArgs());
	}
	
	
	@Around("execution(* aopdemo.Aop.*.checkout(..))")
	public void afterLogger(JoinPoint jb)
	{String arg=jb.getArgs()[0].toString();
	System.out.println("after checkout is working  "+arg);
	}
	
//	@Around("execution(* aopdemo.Aop.ShoppingCart.checkout(..))")
//	public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable {
//	    System.out.println("Around BEFORE checkout: " + java.util.Arrays.toString(pjp.getArgs()));
//	    Object result = pjp.proceed(); // important, continue execution
//	    System.out.println("Around AFTER checkout");
//	    return result;
//	}

	@AfterReturning( pointcut = "execution(* aopdemo.Aop.Checkout.calculation(..))",returning = "retVal")
	public void doAfterReturningTask(Object retVal) {
		System.out.println("Returned value from calculation: " + retVal);
    }
    
	
	@AfterThrowing("within(aopdemo.Aop.ShoppingCart)")
	public void checkException() {
	    System.out.println("AfterThrowing executed: Exception in ShoppingCart");
	}

}
