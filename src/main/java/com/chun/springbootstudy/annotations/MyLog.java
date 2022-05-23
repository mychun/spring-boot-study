package com.chun.springbootstudy.annotations;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
}
