package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 부수적인 관심사만 모아놓은 클래스...
 * Advice Class
 */
public class LogginAdvice {
	private Log log = LogFactory.getLog(getClass());

	public void logPush(ProceedingJoinPoint pjp) throws Throwable{
        log.info("\ncheck...before logging...");

        Object ret = pjp.proceed();//target으로 위빙되는 시점
        System.out.println("target method return..."+ret);
	}

}
