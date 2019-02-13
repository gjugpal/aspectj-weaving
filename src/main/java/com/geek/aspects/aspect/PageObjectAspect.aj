package com.geek.aspects.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;
import java.util.stream.Stream;


@Aspect
public class PageObjectAspect extends Aspects
{
    @Pointcut("execution(public * *(..)) && !@annotation(com.geek.aspects.annotations.Secure)")
    public void anyPublicMethod() {
    }

    @Around("anyPublicMethod()")
    public Object pageObjectLogging(final ProceedingJoinPoint pjp) throws Throwable {
        final Signature signature = pjp.getStaticPart().getSignature();

        if (signature instanceof MethodSignature) {
            final MethodSignature method = (MethodSignature) signature;
            String returnType = ((MethodSignature) pjp.getSignature()).getReturnType().getName();

            String pageObject = getPageObjectName(pjp);
            log.info("Page Object: " + pageObject);

            final String methodName = method.getName();
            List<String> params = getMethodParameters(pjp, false);

            String logLine = params.isEmpty() ? String.format("Method: %s()", methodName) : String.format("Method: %s(%s)", methodName, StringUtils.join(params, ","));
            log.info(logLine);

            // No need to log the return value if its the PageObject object
            if (Stream.of(pageObject, "void").anyMatch(returnType::contains)) {
                returnValue = false;
            }
            else {
                if(returnType.contains(".")) {
                    final String[] returnTypeArray = returnType.split("\\.");
                    returnType = returnTypeArray[returnTypeArray.length - 1];
                }

                log.info("Return Type: " + returnType);
            }
        }

        return pjp.proceed();
    }

    @AfterReturning(pointcut="anyPublicMethod()", returning = "r")
    public void returnLogging(Object r) {
        if(returnValue && r != null && !r.toString().contains(".")) {
            log.info("Returns: " + r);
        }
    }

}