package com.medical.constants;

public interface RegexConstant {
    String NAME_SURNAME_REGEX_UK = "[[А-ЯҐІЇЄ]&&[^ЁЫЭЪ]][[а-яґєії\\']&&[^ёыэъ]]{1,18}[[а-яґєії]&&[^ёыэъ]]";
    String NAME_SURNAME_REGEX_EN = "[A-Z][a-z]+";
    String LOGIN_PASSWORD_REGEX = "[A-Za-z0-9_@]{8,20}";
}
