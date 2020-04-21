package com.github.xuchengen.pm.enums;

/**
 * 支付方式枚举<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/20 4:13 下午<br>
 */
public enum PaymentMethodsEnum {

    ACCOUNT("account", "账户"),
    VOUCHER("voucher", "电子凭证"),
    SMS("sms", "短信"),
    WIRE("wire", "电汇"),
    ALL("all", "全部");

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    PaymentMethodsEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
