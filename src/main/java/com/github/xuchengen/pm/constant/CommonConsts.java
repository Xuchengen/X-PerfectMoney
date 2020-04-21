package com.github.xuchengen.pm.constant;

/**
 * 常量<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/20 3:24 下午<br>
 */
public interface CommonConsts {

    /**
     * 表单隐藏域
     */
    String HIDDEN_INPUT = "<input name='(.*?)' type='hidden' value='(.*?)'>";

    /**
     * CVS分隔符
     */
    String CVS_SPLIT = ",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

    /**
     * 表单隐藏域模板
     */
    String INPUT_TEMPLATE = "<input type=\"hidden\" name=\"%s\" value=\"%s\">";
}
