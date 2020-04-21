package com.github.xuchengen.pm;

import com.github.xuchengen.pm.annotation.ParserField;
import com.github.xuchengen.pm.constant.CommonConsts;
import com.github.xuchengen.pm.domain.AccountBalanceInfo;
import com.github.xuchengen.pm.domain.EVoucherInfo;
import com.github.xuchengen.pm.domain.HistoryBillInfo;
import com.github.xuchengen.pm.handler.IPaymentFormParserHandler;
import com.github.xuchengen.pm.request.PaymentRequest;
import com.github.xuchengen.pm.response.*;
import com.github.xuchengen.pm.utils.DateTool;
import com.github.xuchengen.pm.utils.HttpTool;
import com.github.xuchengen.pm.utils.MD5Tool;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PerfectMoney完美货币客户端<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/16 9:58 上午<br>
 */
public class PerfectMoneyClient {

    /**
     * PerfectMoney主机地址
     */
    private String host;

    /**
     * 登录帐号
     */
    private final String accountID;

    /**
     * 登录密码
     */
    private final String passPhrase;

    /**
     * 备用密码
     */
    private final String alternatePassPhrase;

    /**
     * 使用代理标识
     */
    private final boolean useProxy;

    /**
     * HTTP代理IP
     */
    private final String httpProxyIp;

    /**
     * HTTP代理端口
     */
    private final Integer httpProxyPort;

    public String getAccountID() {
        return accountID;
    }

    public String getPassPhrase() {
        return passPhrase;
    }

    public boolean isUseProxy() {
        return useProxy;
    }

    public String getHttpProxyIp() {
        return httpProxyIp;
    }

    public Integer getHttpProxyPort() {
        return httpProxyPort;
    }

    /**
     * 构造方法
     *
     * @param builder 构建者
     */
    public PerfectMoneyClient(Builder builder) {
        this.host = builder.host;
        this.accountID = builder.accountID;
        this.passPhrase = builder.passPhrase;
        this.alternatePassPhrase = builder.alternatePassPhrase;
        this.useProxy = builder.useProxy;
        this.httpProxyIp = builder.httpProxyIp;
        this.httpProxyPort = builder.httpProxyPort;
    }

    /**
     * 构建者
     */
    public static class Builder {

        private String host;

        private String accountID;

        private String passPhrase;

        private String alternatePassPhrase;

        private boolean useProxy;

        private String httpProxyIp;

        private Integer httpProxyPort;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setAccountID(String accountID) {
            this.accountID = accountID;
            return this;
        }

        public Builder setPassPhrase(String passPhrase) {
            this.passPhrase = passPhrase;
            return this;
        }

        public Builder setUseProxy(boolean useProxy) {
            this.useProxy = useProxy;
            return this;
        }

        public Builder setHttpProxyIp(String httpProxyIp) {
            this.httpProxyIp = httpProxyIp;
            return this;
        }

        public Builder setHttpProxyPort(Integer httpProxyPort) {
            this.httpProxyPort = httpProxyPort;
            return this;
        }

        public Builder setAlternatePassPhrase(String alternatePassPhrase) {
            this.alternatePassPhrase = alternatePassPhrase;
            return this;
        }

        public PerfectMoneyClient build() {
            return new PerfectMoneyClient(this);
        }
    }

    /**
     * 获取账户余额列表
     *
     * @return AccountBalanceResponse
     */
    public AccountBalanceResponse getAccountBalanceList() {
        final String reqPath = "/acct/balance.asp";

        HttpTool httpTool = HttpTool.get(this.host + reqPath)
                .form("AccountID", this.accountID)
                .form("PassPhrase", this.passPhrase);

        if (useProxy) {
            httpTool.useProxy(httpProxyIp, httpProxyPort);
        }

        if (!httpTool.ok()) {
            throw new RuntimeException("request failed");
        }

        String html = httpTool.body();

        Matcher matcher = Pattern.compile(CommonConsts.HIDDEN_INPUT).matcher(html);

        List<AccountBalanceInfo> items = new ArrayList<AccountBalanceInfo>();

        AccountBalanceResponse accountBalanceResponse;

        while (matcher.find()) {

            int groupCount = matcher.groupCount();

            String key = "", value = "";

            for (int i = 0; i <= groupCount; i++) {
                if (i == 1) {
                    key = matcher.group(i).trim();
                }
                if (i == 2) {
                    value = matcher.group(i).trim();
                }
            }

            if ("ERROR".equalsIgnoreCase(key)) {
                accountBalanceResponse = new AccountBalanceResponse();
                accountBalanceResponse.setAccountBalanceInfos(items);
                accountBalanceResponse.setErrorMessage(value);
                accountBalanceResponse.setSuccess(false);
                return accountBalanceResponse;
            }

            AccountBalanceInfo accountBalanceInfo = new AccountBalanceInfo();
            accountBalanceInfo.setBalance(new BigDecimal(value));
            accountBalanceInfo.setAccountNo(key);

            items.add(accountBalanceInfo);
        }

        if (items.size() <= 0) {
            throw new RuntimeException("No matching records");
        }

        accountBalanceResponse = new AccountBalanceResponse();
        accountBalanceResponse.setSuccess(true);
        accountBalanceResponse.setAccountBalanceInfos(items);
        accountBalanceResponse.setErrorMessage("search successful");
        return accountBalanceResponse;
    }

    /**
     * 获取历史账单列表
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return HistoryBillResponse
     */
    public HistoryBillResponse getHistoryBillList(Date startDate, Date endDate) {
        final String reqPath = "/acct/historycsv.asp";
        HistoryBillResponse historyBillResponse;

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        HttpTool httpTool = HttpTool.get(this.host + reqPath)
                .form("startmonth", startCalendar.get(Calendar.MONTH) + 1)
                .form("startday", startCalendar.get(Calendar.DAY_OF_MONTH))
                .form("startyear", startCalendar.get(Calendar.YEAR))
                .form("endmonth", endCalendar.get(Calendar.MONTH) + 1)
                .form("endday", endCalendar.get(Calendar.DAY_OF_MONTH))
                .form("endyear", endCalendar.get(Calendar.YEAR))
                .form("AccountID", this.accountID)
                .form("PassPhrase", this.passPhrase);

        if (useProxy) {
            httpTool.useProxy(httpProxyIp, httpProxyPort);
        }

        if (!httpTool.ok()) {
            throw new RuntimeException("request failed");
        }

        String cvsStr = httpTool.body();

        String[] lines = cvsStr.split(System.getProperty("line.separator"));

        if (!lines[0].equals("Time,Type,Batch,Currency,Amount,Fee,Payer Account,Payee Account,Payment ID,Memo")) {
            historyBillResponse = new HistoryBillResponse();
            historyBillResponse.setSuccess(false);
            historyBillResponse.setErrorMessage(lines[0]);
            return historyBillResponse;
        }

        List<HistoryBillInfo> historyBillInfos = new ArrayList<HistoryBillInfo>();

        for (int i = 1; i < lines.length; i++) {
            HistoryBillInfo historyBillInfo = new HistoryBillInfo();
            String[] fieldArr = lines[i].trim().split(CommonConsts.CVS_SPLIT, -1);
            if (fieldArr.length >= 10) {
                historyBillInfo.setTime(DateTool.toDate(fieldArr[0].trim(), DateTool.ENGLISH_DATETIME));
                historyBillInfo.setType(fieldArr[1].trim());
                historyBillInfo.setBatch(fieldArr[2].trim());
                historyBillInfo.setCurrency(fieldArr[3].trim());
                historyBillInfo.setAmount(new BigDecimal(fieldArr[4].trim()));
                historyBillInfo.setFee(new BigDecimal(fieldArr[5].trim()));
                historyBillInfo.setPayerAccount(fieldArr[6].trim());
                historyBillInfo.setPayeeAccount(fieldArr[7].trim());
                historyBillInfo.setPaymentId(fieldArr[8].trim());
                historyBillInfo.setMemo(fieldArr[9].trim());
                historyBillInfos.add(historyBillInfo);
            } else {
                historyBillResponse = new HistoryBillResponse();
                historyBillResponse.setSuccess(true);
                historyBillResponse.setErrorMessage(fieldArr[0]);
                historyBillResponse.setHistoryBillInfos(historyBillInfos);
                return historyBillResponse;
            }
        }

        historyBillResponse = new HistoryBillResponse();
        historyBillResponse.setSuccess(true);
        historyBillResponse.setHistoryBillInfos(historyBillInfos);
        historyBillResponse.setErrorMessage("search successful");
        return historyBillResponse;
    }

    /**
     * 转账
     *
     * @param payerAccount 付款人账号
     * @param payeeAccount 收款人账号
     * @param amount       转账金额
     * @param paymentId    转账流水号
     * @return TransferReceiptInfoResponse
     */
    public TransferReceiptInfoResponse transfer(String payerAccount, String payeeAccount,
                                                BigDecimal amount, String paymentId) {
        final String reqPath = "/acct/confirm.asp";

        HttpTool httpTool = HttpTool.get(this.host + reqPath)
                .form("AccountID", this.accountID)
                .form("PassPhrase", this.passPhrase)
                .form("Payer_Account", payerAccount)
                .form("Payee_Account", payeeAccount)
                .form("Amount", amount)
                .form("PAYMENT_ID", paymentId)
                .form("PAY_IN", 1);

        if (useProxy) {
            httpTool.useProxy(httpProxyIp, httpProxyPort);
        }

        if (!httpTool.ok()) {
            throw new RuntimeException("request failed");
        }

        String html = httpTool.body();

        Matcher matcher = Pattern.compile(CommonConsts.HIDDEN_INPUT).matcher(html);

        TransferReceiptInfoResponse transferReceiptInfoResponse = new TransferReceiptInfoResponse();

        while (matcher.find()) {

            int groupCount = matcher.groupCount();

            String key = "", value = "";

            for (int i = 0; i <= groupCount; i++) {
                if (i == 1) {
                    key = matcher.group(i).trim();
                }
                if (i == 2) {
                    value = matcher.group(i).trim();
                }
            }

            if ("ERROR".equalsIgnoreCase(key)) {
                transferReceiptInfoResponse.setErrorMessage(value);
                transferReceiptInfoResponse.setSuccess(false);
                return transferReceiptInfoResponse;
            }

            if ("Payee_Account_Name".equalsIgnoreCase(key)) {
                transferReceiptInfoResponse.setPayeeAccountName(value);
            }

            if ("Payee_Account".equalsIgnoreCase(key)) {
                transferReceiptInfoResponse.setPayeeAccount(value);
            }

            if ("Payer_Account".equalsIgnoreCase(key)) {
                transferReceiptInfoResponse.setPayerAccount(value);
            }

            if ("PAYMENT_AMOUNT".equalsIgnoreCase(key)) {
                transferReceiptInfoResponse.setPaymentAmount(new BigDecimal(value));
            }

            if ("PAYMENT_BATCH_NUM".equalsIgnoreCase(key)) {
                transferReceiptInfoResponse.setPaymentBatchNum(value);
            }

            if ("PAYMENT_ID".equalsIgnoreCase(key)) {
                transferReceiptInfoResponse.setPaymentId(value);
            }
        }

        transferReceiptInfoResponse.setSuccess(true);
        transferReceiptInfoResponse.setErrorMessage("successful transfer");
        return transferReceiptInfoResponse;
    }

    /**
     * MD5验证
     *
     * @param paymentId       支付流水号
     * @param payeeAccount    收款人账号
     * @param payerAccount    付款人账号
     * @param paymentAmount   支付金额
     * @param paymentUnits    支付货币单位
     * @param paymentBatchNum 支付批次号
     * @param timestampGMT    时间
     * @param v2Hash          V2_HASH
     * @return 验证结果
     */
    public boolean verify(String paymentId, String payeeAccount, String payerAccount,
                          String paymentAmount, String paymentUnits, String paymentBatchNum,
                          String timestampGMT, String v2Hash) {
        String alternatePhraseHash = MD5Tool.getMd5(this.alternatePassPhrase).toUpperCase();
        String templateStr = "%s:%s:%s:%s:%s:%s:%s:%s";
        String formatStr = String.format(templateStr, paymentId, payeeAccount, paymentAmount, paymentUnits,
                paymentBatchNum, payerAccount, alternatePhraseHash, timestampGMT);
        String hash = MD5Tool.getMd5(formatStr).toUpperCase();
        return hash.equals(v2Hash);
    }

    /**
     * 创建电子凭证
     *
     * @param payerAccount 付款人账户
     * @param amount       金额
     * @return CreateEVoucherResponse
     */
    public CreateEVoucherResponse createEVoucher(String payerAccount, BigDecimal amount) {
        final String reqPath = "/acct/ev_create.asp";

        HttpTool httpTool = HttpTool.get(this.host + reqPath)
                .form("AccountID", this.accountID)
                .form("PassPhrase", this.passPhrase)
                .form("Payer_Account", payerAccount)
                .form("Amount", amount);

        if (useProxy) {
            httpTool.useProxy(httpProxyIp, httpProxyPort);
        }

        if (!httpTool.ok()) {
            throw new RuntimeException("request failed");
        }

        String html = httpTool.body();

        Matcher matcher = Pattern.compile(CommonConsts.HIDDEN_INPUT).matcher(html);

        CreateEVoucherResponse createEVoucherResponse = new CreateEVoucherResponse();

        while (matcher.find()) {

            int groupCount = matcher.groupCount();

            String key = "", value = "";

            for (int i = 0; i <= groupCount; i++) {
                if (i == 1) {
                    key = matcher.group(i).trim();
                }
                if (i == 2) {
                    value = matcher.group(i).trim();
                }
            }

            if ("ERROR".equalsIgnoreCase(key)) {
                createEVoucherResponse.setErrorMessage(value);
                createEVoucherResponse.setSuccess(false);
                return createEVoucherResponse;
            }

            if ("Payer_Account".equalsIgnoreCase(key)) {
                createEVoucherResponse.setPayerAccount(value);
            }

            if ("PAYMENT_AMOUNT".equalsIgnoreCase(key)) {
                createEVoucherResponse.setPaymentAmount(new BigDecimal(value));
            }

            if ("PAYMENT_BATCH_NUM".equalsIgnoreCase(key)) {
                createEVoucherResponse.setPaymentBatchNum(value);
            }

            if ("VOUCHER_NUM".equalsIgnoreCase(key)) {
                createEVoucherResponse.setVoucherNum(value);
            }

            if ("VOUCHER_CODE".equalsIgnoreCase(key)) {
                createEVoucherResponse.setVoucherCode(value);
            }

            if ("VOUCHER_AMOUNT".equalsIgnoreCase(key)) {
                createEVoucherResponse.setVoucherAmount(new BigDecimal(value));
            }
        }

        createEVoucherResponse.setSuccess(true);
        createEVoucherResponse.setErrorMessage("successful transfer");
        return createEVoucherResponse;
    }

    /**
     * 获取历史电子凭证列表
     *
     * @return HistoryEVoucherResponse
     */
    public HistoryEVoucherResponse getHistoryEVoucherList() {
        final String reqPath = "/acct/evcsv.asp";
        HistoryEVoucherResponse historyEVoucherResponse;

        HttpTool httpTool = HttpTool.get(this.host + reqPath)
                .form("AccountID", this.accountID)
                .form("PassPhrase", this.passPhrase);

        if (useProxy) {
            httpTool.useProxy(httpProxyIp, httpProxyPort);
        }

        if (!httpTool.ok()) {
            throw new RuntimeException("request failed");
        }

        String cvsStr = httpTool.body();

        String[] lines = cvsStr.split(System.getProperty("line.separator"));

        if (!lines[0].equals("Created,e-Voucher number,Activation code,Currency,Batch,Payer Account,Payee Account,Activated,Amount")) {
            historyEVoucherResponse = new HistoryEVoucherResponse();
            historyEVoucherResponse.setSuccess(false);
            historyEVoucherResponse.setErrorMessage(lines[0]);
            return historyEVoucherResponse;
        }

        List<EVoucherInfo> eVoucherInfos = new ArrayList<EVoucherInfo>();

        for (int i = 1; i < lines.length; i++) {
            EVoucherInfo eVoucherInfo = new EVoucherInfo();
            String[] fieldArr = lines[i].trim().split(CommonConsts.CVS_SPLIT, -1);
            if (fieldArr.length >= 9) {
                eVoucherInfo.setCreated(DateTool.toDate(fieldArr[0].trim(), DateTool.ENGLISH_DATETIME));
                eVoucherInfo.setEvoucherNumber(fieldArr[1].trim());
                eVoucherInfo.setActivationCode(fieldArr[2].trim());
                eVoucherInfo.setCurrency(fieldArr[3].trim());
                eVoucherInfo.setBatch(fieldArr[4].trim());
                eVoucherInfo.setPayerAccount(fieldArr[5].trim());
                eVoucherInfo.setPayeeAccount(fieldArr[6].trim());
                eVoucherInfo.setActivated(DateTool.toDate(fieldArr[7].trim(), DateTool.ENGLISH_DATETIME));
                eVoucherInfo.setAmount(new BigDecimal(fieldArr[8].trim()));
                eVoucherInfos.add(eVoucherInfo);
            } else {
                historyEVoucherResponse = new HistoryEVoucherResponse();
                historyEVoucherResponse.setSuccess(true);
                historyEVoucherResponse.setErrorMessage(fieldArr[0]);
                historyEVoucherResponse.seteVoucherInfos(eVoucherInfos);
                return historyEVoucherResponse;
            }
        }

        historyEVoucherResponse = new HistoryEVoucherResponse();
        historyEVoucherResponse.setSuccess(true);
        historyEVoucherResponse.seteVoucherInfos(eVoucherInfos);
        historyEVoucherResponse.setErrorMessage("search successful");
        return historyEVoucherResponse;
    }

    /**
     * 构建表单
     *
     * @param request 请求参数
     * @return 表单字符串
     */
    public String buildForm(PaymentRequest request) {
        final String reqPath = "/api/step1.asp";
        StringBuilder formSb = new StringBuilder();
        formSb.append("<form id=\"perfectMoney\" name=\"perfectMoney\" action=\"")
                .append(this.host).append(reqPath).append("\" method=\"POST\">");

        try {
            Field[] fields = request.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                ParserField annotation = field.getAnnotation(ParserField.class);
                if (null == annotation) {
                    throw new RuntimeException("{" + field.getName() + "} The property is not defined ParserFiled.class annotation class");
                }

                String fieldName = annotation.key();
                Class<? extends IPaymentFormParserHandler> parserHandlerClass = annotation.parserHandler();

                IPaymentFormParserHandler parserHandler = parserHandlerClass.newInstance();

                formSb.append(parserHandler.doParser(fieldName, field.get(request)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        formSb.append("</form>");
        formSb.append("<script>document.forms['perfectMoney'].submit();</script>");
        return formSb.toString();
    }
}
