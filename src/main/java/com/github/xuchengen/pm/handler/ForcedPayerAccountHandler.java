package com.github.xuchengen.pm.handler;

import com.github.xuchengen.pm.constant.CommonConsts;

import java.util.List;

/**
 * 强制付款人账户处理器<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/21 12:50 下午<br>
 */
public class ForcedPayerAccountHandler implements IPaymentFormParserHandler {

    @Override
    public String doParser(String filedName, Object object) {
        List<String> params = (List<String>) object;
        StringBuilder sb = new StringBuilder();
        for (String param : params) {
            sb.append(param).append(" ");
        }
        return String.format(CommonConsts.INPUT_TEMPLATE, filedName, sb.toString().trim());
    }
}
