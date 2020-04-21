package com.github.xuchengen.pm.handler;

import com.github.xuchengen.pm.constant.CommonConsts;

/**
 * 默认的表单字段解析处理器<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/21 1:06 下午<br>
 */
public class DefaultFormFieldParserHandler implements IPaymentFormParserHandler {

    @Override
    public String doParser(String filedName, Object object) {
        return String.format(CommonConsts.INPUT_TEMPLATE, filedName, null != object ? object : "");
    }

}
