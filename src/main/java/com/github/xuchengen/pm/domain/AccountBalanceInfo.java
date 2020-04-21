package com.github.xuchengen.pm.domain;

import java.math.BigDecimal;

/**
 * 账户余额<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/16 1:47 下午<br>
 */
public class AccountBalanceInfo {

    /**
     * 账户号
     */
    private String accountNo;

    /**
     * 余额
     */
    private BigDecimal balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountBalanceInfo{" +
                "accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
