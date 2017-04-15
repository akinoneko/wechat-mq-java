package com.wechat.common.annotation;

import java.lang.annotation.*;

/**
 * Created by akinoneko on 2017/4/14.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {

    String description() default "";
}
