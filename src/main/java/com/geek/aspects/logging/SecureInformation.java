package com.geek.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.logging.Logger;

/**
 * Logs all methods which are tagged with the @Secure annotation, replacing all parameter values
 * with asterisk's for security reasons.
 *
 * Created by gurdeepjugpal on 10/07/2014.
 */
@Aspect
public class SecureInformation {


    @Pointcut("execution(public * *(..)) && @annotation(com.geek.aspects.annotations.Secure)")
    public void anySecureMethod()
    {
    }



    @Around("anySecureMethod()")
    public Object secureInformationLogging(final ProceedingJoinPoint pjp) throws Throwable
    {
        Logger log;
        log = Logger.getLogger(Thread.currentThread().getName());

        final Signature signature = pjp.getStaticPart().getSignature();
        if (signature instanceof MethodSignature)
        {

            final MethodSignature method = (MethodSignature) signature;
            final String className = pjp.getSignature().getDeclaringType().getName();
            final String methodName = method.getName();

            String pageObject = className.replaceAll("com.geek.aspects.app.", "");

            log.info("Page Object Name: " + pageObject);
            log.info("Method Name: " + methodName);

            final String[] parameterNames = method.getParameterNames();
            final Object[] methodArgs = pjp.getArgs();

            for(int i =0; i < parameterNames.length; i++)
            {
                log.info("Parameter Name: " + parameterNames[i]);
                String secureText = methodArgs[i].toString();
                secureText = secureText.replaceAll(".","*");
                log.info("Parameter Value: " + secureText);
            }

        }

        return pjp.proceed();
    }
}