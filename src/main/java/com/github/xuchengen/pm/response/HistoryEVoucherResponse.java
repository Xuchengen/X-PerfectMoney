package com.github.xuchengen.pm.response;

import com.github.xuchengen.pm.domain.EVoucherInfo;

import java.util.List;

/**
 * 历史电子凭证信息响应模型<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/20 2:59 下午<br>
 */
public class HistoryEVoucherResponse extends AbsResponse {

    private List<EVoucherInfo> eVoucherInfos;

    public List<EVoucherInfo> geteVoucherInfos() {
        return eVoucherInfos;
    }

    public void seteVoucherInfos(List<EVoucherInfo> eVoucherInfos) {
        this.eVoucherInfos = eVoucherInfos;
    }

    @Override
    public String toString() {
        return "HistoryEVoucherResponse{" +
                "eVoucherInfos=" + eVoucherInfos +
                "} " + super.toString();
    }
}
