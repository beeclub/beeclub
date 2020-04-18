package cn.h.beeclub.core.auth;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    String value() default "";
    String name() default "";
    String url() default "";
    String msg() default "";
}
