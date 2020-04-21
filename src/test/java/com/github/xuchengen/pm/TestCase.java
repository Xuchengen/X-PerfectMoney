package com.github.xuchengen.pm;

import com.github.xuchengen.pm.enums.InterfaceLanguageEnum;
import com.github.xuchengen.pm.enums.PaymentUnitsEnum;
import com.github.xuchengen.pm.enums.PaymentUrlMethodEnum;
import com.github.xuchengen.pm.request.PaymentRequest;
import com.github.xuchengen.pm.response.*;
import com.github.xuchengen.pm.utils.DateTool;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 测试用例<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/21 4:25 下午<br>
 */
public class TestCase {

    private PerfectMoneyClient perfectMoneyClient;

    @Before
    public void before() {
        perfectMoneyClient = new PerfectMoneyClient.Builder()
                .setHost("https://perfectmoney.com")
                .setAccountID("your login account")
                .setPassPhrase("your login password")
                .setAlternatePassPhrase("your passphrase")
                .build();
    }

    @Test
    public void getHistoryBillList() {
        Date startDate = DateTool.toDate("2020-01-01", "yyyy-MM-dd");
        Date endDate = DateTool.toDate("2020-01-01", "yyyy-MM-dd");
        HistoryBillResponse response = perfectMoneyClient.getHistoryBillList(startDate, endDate);
        System.out.println(response);
    }

    @Test
    public void getAccountBalanceList() {
        AccountBalanceResponse response = perfectMoneyClient.getAccountBalanceList();
        System.out.println(response);
    }

    @Test
    public void transfer() {
        TransferReceiptInfoResponse response = perfectMoneyClient.transfer("payer account", "payee account"
                , new BigDecimal("0.01"), "payment id");
        System.out.println(response);
    }

    @Test
    public void createEVoucher() {
        CreateEVoucherResponse response = perfectMoneyClient.createEVoucher("payer account", new BigDecimal("1"));
        System.out.println(response);
    }

    @Test
    public void getHistoryEVoucherList() {
        HistoryEVoucherResponse response = perfectMoneyClient.getHistoryEVoucherList();
        System.out.println(response);
    }

    @Test
    public void buildForm() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPayeeAccount("U5232354");
        paymentRequest.setPayeeName("上海永达汽车集团有限公司");
        paymentRequest.setPaymentAmount(new BigDecimal("0.01"));
        paymentRequest.setPaymentUnits(PaymentUnitsEnum.USD);
        paymentRequest.setPaymentId("0000000001");
        paymentRequest.setStatusUrl("https://www.xuchengen.cn/status");
        paymentRequest.setPaymentUrl("https://www.xuchengen.cn/paymentUrl");
        paymentRequest.setPaymentUrlMethod(PaymentUrlMethodEnum.POST);
        paymentRequest.setNopaymentUrl("https://www.xuchengen.cn/nopaymentUrl");
        paymentRequest.setNopaymentUrlMethod(PaymentUrlMethodEnum.POST);

        HashMap<String, String> baggMap = new HashMap<String, String>();
        baggMap.put("CUST_PARAM1", "1");
        baggMap.put("CUST_PARAM2", "2");
        baggMap.put("CUST_PARAM3", "3");

        ArrayList<String> account = new ArrayList<String>();
        account.add("9753383");

        paymentRequest.setBaggageFields(baggMap);
        paymentRequest.setSuggestedMemo("上海永达汽车集团有限公司——保时捷II");
        paymentRequest.setSuggestedMemoNochange("上海永达汽车集团有限公司——保时捷II");
        paymentRequest.setForcedPayerAccount(account);
        paymentRequest.setInterfaceLanguage(InterfaceLanguageEnum.ZH_CN.getCode());
        String form = perfectMoneyClient.buildForm(paymentRequest);
        System.out.println(form);
    }

    @Test
    public void verify() {
        //TODO you can you up
    }
}
