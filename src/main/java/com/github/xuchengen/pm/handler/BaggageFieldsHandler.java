package com.github.xuchengen.pm.handler;

import com.github.xuchengen.pm.constant.CommonConsts;

import java.util.HashMap;
import java.util.Map;

/**
 * 拓展字段处理器<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/21 1:15 下午<br>
 */
public class BaggageFieldsHandler implements IPaymentFormParserHandler {

    @Override
    public String doParser(String filedName, Object object) {
        Map<String, String> params = (HashMap<String, String>) object;
        StringBuilder filedSb = new StringBuilder();
        StringBuilder baggageSb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            baggageSb.append(entry.getKey()).append(" ");
            filedSb.append(String.format(CommonConsts.INPUT_TEMPLATE, entry.getKey(), entry.getValue()));
        }
        String str = String.format(CommonConsts.INPUT_TEMPLATE, filedName, baggageSb.toString().trim());
        return str + filedSb;
    }
}
