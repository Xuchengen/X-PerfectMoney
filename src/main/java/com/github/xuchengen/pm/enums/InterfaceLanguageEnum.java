package com.github.xuchengen.pm.enums;

/**
 * 界面语言枚举<br>
 * 作者：徐承恩<br>
 * 邮箱：xuchengen@gmail.com<br>
 * 日期：2020/4/21 3:47 下午<br>
 */
public enum InterfaceLanguageEnum {

    EN_US("en_US", "U.S. English"),
    DE_DE("de_DE", "Deutsch"),
    EL_GR("el_GR", "Ελληνικά"),
    ZH_CN("zh_CN", "中文"),
    JA_JP("ja_JP", "日本語"),
    KO_KR("ko_KR", "한국어"),
    ES_ES("es_ES", "Español"),
    FR_FR("fr_FR", "Français"),
    RU_RU("ru_RU", "Русский"),
    UK_UA("uk_UA", "Українська"),
    IT_IT("it_IT", "Italiano"),
    PT_PT("pt_PT", "Português"),
    AR_AE("ar_AE", "العربية"),
    FA_IR("fa_IR", "فارسی"),
    TH_TH("th_TH", "ไทย"),
    ID_ID("id_ID", "Indonesia"),
    MS_MY("ms_MY", "Malaysian"),
    TR_TR("tr_TR", "Türkçe"),
    PL_PL("pl_PL", "Polski"),
    RO_RO("ro_RO", "Român");

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    InterfaceLanguageEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
