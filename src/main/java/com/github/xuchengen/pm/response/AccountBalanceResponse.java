package com.github.xuchengen.pm.response;

import com.github.xuchengen.pm.domain.AccountBalanceInfo;

import java.util.List;

/**
 * 查询账户余额响应模型<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/16 1:42 下午<br>
 */
public class AccountBalanceResponse extends AbsResponse {

    /**
     * 余额列表
     */
    private List<AccountBalanceInfo> accountBalanceInfos;

    public List<AccountBalanceInfo> getAccountBalanceInfos() {
        return accountBalanceInfos;
    }

    public void setAccountBalanceInfos(List<AccountBalanceInfo> accountBalanceInfos) {
        this.accountBalanceInfos = accountBalanceInfos;
    }

    @Override
    public String toString() {
        return "AccountBalanceResponse{" +
                "accountBalanceInfos=" + accountBalanceInfos +
                "} " + super.toString();
    }
}
