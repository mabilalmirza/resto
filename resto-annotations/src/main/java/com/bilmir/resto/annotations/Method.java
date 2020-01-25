package com.bilmir.resto.annotations;


import com.bilmir.resto.core.HttpMethod;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Method {
    HttpMethod value();
}
