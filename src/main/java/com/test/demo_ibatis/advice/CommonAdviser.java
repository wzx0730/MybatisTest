package com.test.demo_ibatis.advice;



import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonAdviser {
    static {
        System.out.println("切面");
    }
    private static Logger logger  = Logger.getLogger(CommonAdviser.class);

    @Pointcut("execution(* com.test.demo_ibatis.service.Impl.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint jp){
        logger.debug("前置方法"+jp.getSignature().getName());
    }

    @AfterReturning("pointCut()")
    public void afterR(JoinPoint jp){
        logger.debug("后置方法"+jp.getSignature().getName());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        logger.debug("环绕前置" + pjp.getSignature().getName());
        System.out.println("环绕前置"+ pjp.getSignature().getName());
        Object proceed = null;
        try {
            proceed = pjp.proceed();
            logger.debug("结果" + proceed.toString());

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

}
