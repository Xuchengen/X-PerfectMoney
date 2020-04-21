package com.github.xuchengen.pm.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 电子凭证信息<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/20 2:30 下午<br>
 */
public class EVoucherInfo {

    /**
     * 创建时间
     */
    public Date created;

    /**
     * 电子凭证号码
     */
    private String evoucherNumber;

    /**
     * 电子凭证激活码
     */
    private String activationCode;

    /**
     * 货币单位
     */
    private String currency;

    /**
     * 批次号码
     */
    private String batch;

    /**
     * 付款人账户
     */
    private String payerAccount;

    /**
     * 收款人账户
     */
    private String payeeAccount;

    /**
     * 激活时间
     */
    private Date activated;

    /**
     * 金额
     */
    private BigDecimal amount;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getEvoucherNumber() {
        return evoucherNumber;
    }

    public void setEvoucherNumber(String evoucherNumber) {
        this.evoucherNumber = evoucherNumber;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public Date getActivated() {
        return activated;
    }

    public void setActivated(Date activated) {
        this.activated = activated;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "EVoucherInfo{" +
                "created=" + created +
                ", evoucherNumber='" + evoucherNumber + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", currency='" + currency + '\'' +
                ", batch='" + batch + '\'' +
                ", payerAccount='" + payerAccount + '\'' +
                ", payeeAccount='" + payeeAccount + '\'' +
                ", activated='" + activated + '\'' +
                ", amount=" + amount +
                '}';
    }
}
