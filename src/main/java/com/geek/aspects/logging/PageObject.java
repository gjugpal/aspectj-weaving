package com.geek.aspects.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.logging.Logger;

/**
 * Logs all page object method calls.
 */
@Aspect
public class PageObject
{

    private boolean logReturnValue;

    @Pointcut("execution(public * *(..)) && !@annotation(com.geek.aspects.annotations.Secure)")
    public void anyPublicMethod()
    {
    }

    @Around("anyPublicMethod()")
    public Object pageObjectLogging(final ProceedingJoinPoint pjp) throws Throwable
    {

        System.out.println("its here!!!!!");
//        Logger log;
//        log = Logger.getLogger(Thread.currentThread().getName());
//
//        logReturnValue = true;
//
//        final Signature signature = pjp.getStaticPart().getSignature();
//        if (signature instanceof MethodSignature)
//        {
//            final MethodSignature method = (MethodSignature) signature;
//            final String className = pjp.getSignature().getDeclaringType().getName();
//            String returnType = ((MethodSignature) pjp.getSignature()).getReturnType().getName();
//            final String methodName = method.getName();
//
//            String pageObject = className.replaceAll("com.geek.aspects.app.", "");
//
//            log.info("Page Object Name: " + pageObject);
//            log.info("Method Name: " + methodName);
//
//            final String[] parameterNames = method.getParameterNames();
//            final Object[] methodArgs = pjp.getArgs();
//
//            for(int i =0; i < parameterNames.length; i++){
//
//                log.info("Parameter Name: " + parameterNames[i]);
//                log.info("Parameter Value: " + methodArgs[i]);
//            }
//
//            /* Value of Page Objects doesn't need logging */
//            if(returnType.contains("pageobject"))
//            {
//                logReturnValue = false;
//            }
//
//            /* Void return types don't need logging */
//            if(!returnType.contains("void"))
//            {
//                /* Remove excess text from returnType */
//                if(returnType.contains("."))
//                {
//                    final String[] returnTypeArray = returnType.split("\\.");
//                    returnType = returnTypeArray[returnTypeArray.length - 1];
//                }
//
//                log.info("Return Type: " + returnType);
//
//            }
//
//
//        }

        return pjp.proceed();
    }

    @AfterReturning(pointcut="anyPublicMethod()", returning = "r")
    public void returnLogging(Object r)
    {
//        Logger log;
//        log = Logger.getLogger(Thread.currentThread().getName());
//
//        /* Only log if the value is not null, doesn't contain a . and if the boolean is true
//         * this filters out all possible scenarios where unwanted values were getting logged. */
//        if(logReturnValue && r != null && !r.toString().contains("."))
//        {
//            log.info("Returning Value: " + r);
//        }
    }
}

