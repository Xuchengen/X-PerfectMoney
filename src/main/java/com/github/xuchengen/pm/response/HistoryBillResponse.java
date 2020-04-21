package com.github.xuchengen.pm.response;

import com.github.xuchengen.pm.domain.HistoryBillInfo;

import java.util.List;

/**
 * 历史账单响应模型<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/17 4:13 下午<br>
 */
public class HistoryBillResponse extends AbsResponse {

    private List<HistoryBillInfo> historyBillInfos;

    public List<HistoryBillInfo> getHistoryBillInfos() {
        return historyBillInfos;
    }

    public HistoryBillResponse setHistoryBillInfos(List<HistoryBillInfo> historyBillInfos) {
        this.historyBillInfos = historyBillInfos;
        return this;
    }

    @Override
    public String toString() {
        return "HistoryBillResponse{" +
                "historyBillInfos=" + historyBillInfos +
                "} " + super.toString();
    }
}
