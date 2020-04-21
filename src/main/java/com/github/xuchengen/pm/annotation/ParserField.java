package com.github.xuchengen.pm.annotation;

import com.github.xuchengen.pm.handler.DefaultFormFieldParserHandler;
import com.github.xuchengen.pm.handler.IPaymentFormParserHandler;

import java.lang.annotation.*;

/**
 * 解析字段注解<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/21 1:26 下午<br>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ParserField {

    String key();

    Class<? extends IPaymentFormParserHandler> parserHandler() default DefaultFormFieldParserHandler.class;
}
