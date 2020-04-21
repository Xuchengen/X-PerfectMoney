package com.github.xuchengen.pm.request;

import com.github.xuchengen.pm.annotation.ParserField;
import com.github.xuchengen.pm.enums.PaymentUnitsEnum;
import com.github.xuchengen.pm.enums.PaymentUrlMethodEnum;
import com.github.xuchengen.pm.handler.AvailablePaymentMethodsHandler;
import com.github.xuchengen.pm.handler.BaggageFieldsHandler;
import com.github.xuchengen.pm.handler.ForcedPayerAccountHandler;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 支付请求模型<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/20 4:22 下午<br>
 */
public class PaymentRequest {

    /**
     * 收款人账户
     */
    @ParserField(key = "PAYEE_ACCOUNT")
    public String payeeAccount;

    /**
     * 收款人名称
     */
    @ParserField(key = "PAYEE_NAME")
    public String payeeName;

    /**
     * 支付金额
     */
    @ParserField(key = "PAYMENT_AMOUNT")
    public BigDecimal paymentAmount;

    /**
     * 支付货币单位
     */
    @ParserField(key = "PAYMENT_UNITS")
    public PaymentUnitsEnum paymentUnits;

    /**
     * 支付流水号
     */
    @ParserField(key = "PAYMENT_ID")
    public String paymentId;

    /**
     * 状态通知地址
     */
    @ParserField(key = "STATUS_URL")
    public String statusUrl;

    /**
     * 支付地址
     */
    @ParserField(key = "PAYMENT_URL")
    public String paymentUrl;

    /**
     * 支付地址跳转方式——支付完成同步跳转
     */
    @ParserField(key = "PAYMENT_URL_METHOD")
    public PaymentUrlMethodEnum paymentUrlMethod;

    /**
     * 未支付地址——取消支付同步跳转
     */
    @ParserField(key = "NOPAYMENT_URL")
    public String nopaymentUrl;

    /**
     * 未支付地址跳转方式
     */
    @ParserField(key = "NOPAYMENT_URL_METHOD")
    public PaymentUrlMethodEnum nopaymentUrlMethod;

    /**
     * 拓展字段
     */
    @ParserField(key = "BAGGAGE_FIELDS", parserHandler = BaggageFieldsHandler.class)
    public Map<String, String> baggageFields;

    /**
     * 备注
     */
    @ParserField(key = "SUGGESTED_MEMO")
    public String suggestedMemo;

    /**
     * 如果输入1则备注字段为不可编辑状态
     */
    @ParserField(key = "SUGGESTED_MEMO_NOCHANGE")
    public String suggestedMemoNochange;

    /**
     * 强制控制付款人登录帐号
     */
    @ParserField(key = "FORCED_PAYER_ACCOUNT", parserHandler = ForcedPayerAccountHandler.class)
    public List<String> forcedPayerAccount;

    /**
     * 指定付款方式
     */
    @ParserField(key = "AVAILABLE_PAYMENT_METHODS", parserHandler = AvailablePaymentMethodsHandler.class)
    public List<String> availablePaymentMethods;

    /**
     * 默认的支付方式
     */
    @ParserField(key = "DEFAULT_PAYMENT_METHOD")
    public String defaultPaymentMethod;

    /**
     * 强制控制支付方式
     */
    @ParserField(key = "FORCED_PAYMENT_METHOD")
    public String forcedPaymentMethod;

    /**
     * 收银台语言
     */
    @ParserField(key = "INTERFACE_LANGUAGE")
    public String interfaceLanguage;

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentUnitsEnum getPaymentUnits() {
        return paymentUnits;
    }

    public void setPaymentUnits(PaymentUnitsEnum paymentUnits) {
        this.paymentUnits = paymentUnits;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatusUrl() {
        return statusUrl;
    }

    public void setStatusUrl(String statusUrl) {
        this.statusUrl = statusUrl;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public PaymentUrlMethodEnum getPaymentUrlMethod() {
        return paymentUrlMethod;
    }

    public void setPaymentUrlMethod(PaymentUrlMethodEnum paymentUrlMethod) {
        this.paymentUrlMethod = paymentUrlMethod;
    }

    public String getNopaymentUrl() {
        return nopaymentUrl;
    }

    public void setNopaymentUrl(String nopaymentUrl) {
        this.nopaymentUrl = nopaymentUrl;
    }

    public PaymentUrlMethodEnum getNopaymentUrlMethod() {
        return nopaymentUrlMethod;
    }

    public void setNopaymentUrlMethod(PaymentUrlMethodEnum nopaymentUrlMethod) {
        this.nopaymentUrlMethod = nopaymentUrlMethod;
    }

    public Map<String, String> getBaggageFields() {
        return baggageFields;
    }

    public void setBaggageFields(Map<String, String> baggageFields) {
        this.baggageFields = baggageFields;
    }

    public String getSuggestedMemo() {
        return suggestedMemo;
    }

    public void setSuggestedMemo(String suggestedMemo) {
        this.suggestedMemo = suggestedMemo;
    }

    public String getSuggestedMemoNochange() {
        return suggestedMemoNochange;
    }

    public void setSuggestedMemoNochange(String suggestedMemoNochange) {
        this.suggestedMemoNochange = suggestedMemoNochange;
    }

    public List<String> getForcedPayerAccount() {
        return forcedPayerAccount;
    }

    public void setForcedPayerAccount(List<String> forcedPayerAccount) {
        this.forcedPayerAccount = forcedPayerAccount;
    }

    public List<String> getAvailablePaymentMethods() {
        return availablePaymentMethods;
    }

    public void setAvailablePaymentMethods(List<String> availablePaymentMethods) {
        this.availablePaymentMethods = availablePaymentMethods;
    }

    public String getDefaultPaymentMethod() {
        return defaultPaymentMethod;
    }

    public void setDefaultPaymentMethod(String defaultPaymentMethod) {
        this.defaultPaymentMethod = defaultPaymentMethod;
    }

    public String getForcedPaymentMethod() {
        return forcedPaymentMethod;
    }

    public void setForcedPaymentMethod(String forcedPaymentMethod) {
        this.forcedPaymentMethod = forcedPaymentMethod;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "payeeAccount='" + payeeAccount + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentUnits=" + paymentUnits +
                ", paymentId='" + paymentId + '\'' +
                ", statusUrl='" + statusUrl + '\'' +
                ", paymentUrl='" + paymentUrl + '\'' +
                ", paymentUrlMethod=" + paymentUrlMethod +
                ", nopaymentUrl='" + nopaymentUrl + '\'' +
                ", nopaymentUrlMethod='" + nopaymentUrlMethod + '\'' +
                ", baggageFields=" + baggageFields +
                ", suggestedMemo='" + suggestedMemo + '\'' +
                ", suggestedMemoNochange='" + suggestedMemoNochange + '\'' +
                ", forcedPayerAccount=" + forcedPayerAccount +
                ", availablePaymentMethods=" + availablePaymentMethods +
                ", defaultPaymentMethod=" + defaultPaymentMethod +
                ", forcedPaymentMethod=" + forcedPaymentMethod +
                ", interfaceLanguage='" + interfaceLanguage + '\'' +
                '}';
    }
}
