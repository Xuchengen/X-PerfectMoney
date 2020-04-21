package com.github.xuchengen.pm.response;

import java.math.BigDecimal;

/**
 * 转账收据信息响应模型<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/20 10:21 上午<br>
 */
public class TransferReceiptInfoResponse extends AbsResponse {

    /**
     * 收款人账户名称
     */
    private String payeeAccountName;

    /**
     * 收款人账户
     */
    private String payeeAccount;

    /**
     * 付款人账号
     */
    private String payerAccount;

    /**
     * 转账金额
     */
    private BigDecimal paymentAmount;

    /**
     * 转账批次号
     */
    private String paymentBatchNum;

    /**
     * 付款ID
     */
    private String paymentId;

    public String getPayeeAccountName() {
        return payeeAccountName;
    }

    public void setPayeeAccountName(String payeeAccountName) {
        this.payeeAccountName = payeeAccountName;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

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

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "TransferReceiptInfoResponse{" +
                "payeeAccountName='" + payeeAccountName + '\'' +
                ", payeeAccount='" + payeeAccount + '\'' +
                ", payerAccount='" + payerAccount + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentBatchNum='" + paymentBatchNum + '\'' +
                ", paymentId='" + paymentId + '\'' +
                "} " + super.toString();
    }
}
