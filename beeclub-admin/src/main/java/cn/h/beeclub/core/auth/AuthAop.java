package cn.h.beeclub.core.auth;

import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.core.exception.NoAuthException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Set;

//@Aspect
@Slf4j
//@Component
public class AuthAop {

    @Before("execution(* *(..)) && @annotation(cn.h.beeclub.core.auth.Permission)")
    public void before(JoinPoint joinPoint) {
//        joinPoint.
        //Advice
        log.info("oinPoint.getTarget()" + joinPoint.getTarget());
        log.info("joinPoint.getKind()" + joinPoint.getKind());
        log.info("joinPoint.getArgs()" + joinPoint.getArgs());
        log.info("joinPoint.getSignature()" + joinPoint.getSignature());
        log.info("joinPoint.getSourceLocation()" + joinPoint.getSourceLocation());
        log.info("joinPoint.getStaticPart()" + joinPoint.getStaticPart());
        log.info("joinPoint.getThis()" + joinPoint.getThis());

        Object[] args = joinPoint.getArgs();
        Class<?>[] argTypes = new Class[joinPoint.getArgs().length];
        for(int i = 0; i < args.length; i++){
            argTypes[i] = args[i].getClass();
        }

        Class clazz = joinPoint.getTarget().getClass();
        Signature signature = joinPoint.getSignature();

        Method method = null;
        try {
            method = clazz.getMethod(signature.getName(),argTypes );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Permission permission = method.getAnnotation(Permission.class);
        String val = permission.value();
        if(!StringUtils.isEmpty(val)){
            SysAdmin admin = ServletContext.getCurrentAdmin();
            Set<String> permissions = admin.getPermissions();
            if(permissions == null || !permissions.contains(val)){
                String name = permission.name();
                throw new NoAuthException("您无权操作" + StringUtils.isEmpty(name));
            }
        }

//        joinPoint.get
//        Signature signature = joinPoint.getSignature();
//        signature.
    }

}
