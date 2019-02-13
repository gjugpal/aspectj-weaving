package com.geek.aspects.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.ArrayList;
import java.util.List;

class Aspects {

    protected boolean returnValue = true;
    protected Logger log = LogManager.getLogger(this);


    protected String getPageObjectName(ProceedingJoinPoint pjp) {
        final String className = pjp.getSignature().getDeclaringType().getName();
        return className.replaceAll("com.geek.aspects.app.", "");
    }

    protected List<String> getMethodParameters(ProceedingJoinPoint pjp, boolean encrypted) {
        final MethodSignature method = (MethodSignature) pjp.getStaticPart().getSignature();
        final String[] parameterNames = method.getParameterNames();
        Object[] methodArgs = pjp.getArgs();

        List<String> params = new ArrayList<>();

        if(methodArgs.length > 0) {
            for (int i = 0; i < parameterNames.length; i++) {

                String value = encrypted ? methodArgs[i].toString().replaceAll(".", "*") : methodArgs[i].toString();
                params.add(parameterNames[i] + "=" + value);
            }
        }

        return params;
    }

}
