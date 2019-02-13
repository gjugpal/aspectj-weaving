package com.geek.aspects.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;

@Aspect
public class SecureAspect extends Aspects {


    @Pointcut("execution(public * *(..)) && @annotation(com.geek.aspects.annotations.Secure)")
    public void anySecureMethod() {
    }

    @Around("anySecureMethod()")
    public Object redactedDataLogger(final ProceedingJoinPoint pjp) throws Throwable {
        final Signature signature = pjp.getStaticPart().getSignature();

        if (signature instanceof MethodSignature) {
            final MethodSignature method = (MethodSignature) signature;
            final String methodName = method.getName();

            log.info("Page Object: " + getPageObjectName(pjp));

            List<String> params = getMethodParameters(pjp, true);

            String logLine = params.isEmpty() ? String.format("Method: %s()", methodName) : String.format("Method: %s(%s)", methodName, StringUtils.join(params, ","));
            log.info(logLine);
        }

        return pjp.proceed();
    }

}