package com.github.xuchengen.pm.response;

import java.math.BigDecimal;

/**
 * 创建电子凭证响应模型<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/20 2:39 下午<br>
 */
public class CreateEVoucherResponse extends AbsResponse {

    /**
     * 付款人账户
     */
    private String payerAccount;

    /**
     * 支付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 支付批次号
     */
    private String paymentBatchNum;

    /**
     * 电子凭证号码
     */
    private String voucherNum;

    /**
     * 电子凭证激活码
     */
    private String voucherCode;

    /**
     * 电子凭证金额
     */
    private BigDecimal voucherAmount;

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentBatchNum() {
        return paymentBatchNum;
    }

    public void setPaymentBatchNum(String paymentBatchNum) {
        this.paymentBatchNum = paymentBatchNum;
    }

    public String getVoucherNum() {
        return voucherNum;
    }

    public void setVoucherNum(String voucherNum) {
        this.voucherNum = voucherNum;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public BigDecimal getVoucherAmount() {
        return voucherAmount;
    }

    public void setVoucherAmount(BigDecimal voucherAmount) {
        this.voucherAmount = voucherAmount;
    }

    @Override
    public String toString() {
        return "CreateEVoucherResponse{" +
                "payerAccount='" + payerAccount + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentBatchNum='" + paymentBatchNum + '\'' +
                ", voucherNum='" + voucherNum + '\'' +
                ", voucherCode='" + voucherCode + '\'' +
                ", voucherAmount='" + voucherAmount + '\'' +
                "} " + super.toString();
    }
}
