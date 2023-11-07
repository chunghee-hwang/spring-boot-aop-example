package com.aop.annotation.anno;

import java.lang.annotation.*;

@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Custom {
    String firstValue();
    String secondValue();
}
