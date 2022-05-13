package com.chun.springbootstudy.annotations;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
//@Retention(RetentionPolicy.SOURCE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotaion {
    String value() default "";
    String message() default "自定义注解";
}
