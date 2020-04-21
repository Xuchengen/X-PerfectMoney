package com.github.xuchengen.pm.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 历史账单<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/17 3:37 下午<br>
 */
public class HistoryBillInfo {

    /**
     * 交易日期
     */
    private Date time;

    /**
     * 业务类型
     */
    private String type;

    /**
     * 批次号
     */
    private String batch;

    /**
     * 货币
     */
    private String currency;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 交易费用
     */
    private BigDecimal fee;

    /**
     * 付款人账户
     */
    private String payerAccount;

    /**
     * 收款人账户
     */
    private String payeeAccount;

    /**
     * 支付ID
     */
    private String paymentId;

    /**
     * 备注
     */
    private String memo;

    public Date getTime() {
        return time;
    }

    public HistoryBillInfo setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getType() {
        return type;
    }

    public HistoryBillInfo setType(String type) {
        this.type = type;
        return this;
    }

    public String getBatch() {
        return batch;
    }

    public HistoryBillInfo setBatch(String batch) {
        this.batch = batch;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public HistoryBillInfo setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public HistoryBillInfo setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public HistoryBillInfo setFee(BigDecimal fee) {
        this.fee = fee;
        return this;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public HistoryBillInfo setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
        return this;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public HistoryBillInfo setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
        return this;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public HistoryBillInfo setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public HistoryBillInfo setMemo(String memo) {
        this.memo = memo;
        return this;
    }

    @Override
    public String toString() {
        return "HistoryBillInfo{" +
                "time=" + time +
                ", type='" + type + '\'' +
                ", batch='" + batch + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", fee=" + fee +
                ", payerAccount='" + payerAccount + '\'' +
                ", payeeAccount='" + payeeAccount + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
