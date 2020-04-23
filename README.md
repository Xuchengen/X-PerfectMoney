# X-PerfectMoney
<p align="center">
	<a target="_blank" href="https://www.apache.org/licenses/LICENSE-2.0.html">
		<img src="https://img.shields.io/:license-apache-blue.svg"/>
	</a>
	<a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/JDK-1.6+-green.svg"/>
	</a>
	<a target="_blank" href="https://travis-ci.org/Xuchengen/X-PerfectMoney">
		<img src="https://travis-ci.org/Xuchengen/X-PerfectMoney.svg?branch=master"/>
	</a>
	<a target="_blank" href="https://search.maven.org/artifact/com.github.xuchengen/X-PerfectMoney">
        <img src="https://maven-badges.herokuapp.com/maven-central/com.github.xuchengen/X-PerfectMoney/badge.svg" ></img>
    </a> 
	<a target="_blank" href='https://github.com/Xuchengen/X-PerfectMoney'>
		<img src="https://img.shields.io/github/stars/Xuchengen/X-PerfectMoney?style=social" alt="github star"/>
	</a>
</p>

<p align="center">
    <a href="https://www.jetbrains.com/?from=X-UnionPay" target="_blank">
        <img src="https://github.com/Xuchengen/demo-pay/blob/master/asset/jetbrains.svg" width="30%" alt="Jetbrains">
    </a>
</p>

## 简介
X-PerfectMoney——一套基于Java实现的PerfectMoney在线支付接口第三方SDK,旨在屏蔽底层逻辑提供一套简单的API方便调用。

## Maven
```
<dependency>
  <groupId>com.github.xuchengen</groupId>
  <artifactId>X-PerfectMoney</artifactId>
  <version>1.0</version>
</dependency>
```

## Sample
```
PerfectMoneyClient perfectMoneyClient = new PerfectMoneyClient.Builder()
                .setHost("https://perfectmoney.com")
                .setAccountID("your login account")
                .setPassPhrase("your login password")
                .setAlternatePassPhrase("your passphrase")
                .build();

Date startDate = DateTool.toDate("2020-01-01", "yyyy-MM-dd");
Date endDate = DateTool.toDate("2020-01-01", "yyyy-MM-dd");
HistoryBillResponse response = perfectMoneyClient.getHistoryBillList(startDate, endDate);
```

## 特别鸣谢
* <a href="https://github.com/looly/hutool" title="一套保持Java甜蜜的工具">Hutool——一套保持Java甜蜜的工具</a>

* <a href="http://ibeetl.com/" title="Beetl国产高性能Java模板引擎">Beetl——国产高性能Java模板引擎</a>

* <a href="https://github.com/Javen205/IJPay" title="IJPay让支付触手可及">IJPay——IJPay让支付触手可及</a>

* <a href="https://www.jetbrains.com/?from=X-UnionPay" title="专业人士和团队的开发人员工具">Jetbrains——专业人士和团队的开发人员工具</a>

以上排名不分先后。

## 友情捐赠
您的捐赠将用于购买JetBrains旗下IDEA开发工具正版序列号，并进行共享。
<p align="center">
    <a href="https://github.com/Xuchengen/demo-pay/blob/master/asset/unionpay.jpeg" target="_blank">
        <img src="https://github.com/Xuchengen/demo-pay/blob/master/asset/unionpay.jpeg" width="30%" alt="银联支付">
    </a>
    <a href="https://github.com/Xuchengen/demo-pay/blob/master/asset/wechat.jpeg" target="_blank">
        <img src="https://github.com/Xuchengen/demo-pay/blob/master/asset/wechat.jpeg" width="30%" alt="微信支付">
    </a>
    <a href="https://github.com/Xuchengen/demo-pay/blob/master/asset/alipay.jpeg" target="_blank">
        <img src="https://github.com/Xuchengen/demo-pay/blob/master/asset/alipay.jpeg" width="30%" alt="支付宝">
    </a>
</p>
