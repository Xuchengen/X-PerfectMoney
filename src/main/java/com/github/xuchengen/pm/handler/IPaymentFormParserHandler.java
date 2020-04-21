package com.github.xuchengen.pm.handler;

/**
 * 付款表单解析处理器接口<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/21 12:46 下午<br>
 */
public interface IPaymentFormParserHandler {

    /**
     * 解析
     *
     * @param filedName 字段名称
     * @param object    参数
     * @return 表单字符串
     */
    String doParser(String filedName, Object object);

}
