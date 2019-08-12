package cn.starpost.wmspda.util.widget;

public enum RegexMode {

    SINGLE_LINE(""),
    SINGLE_LINE_NUMBERS_ENGLISH(""),
    SINGLE_LINE_NUMBERS_ENGLISH_CHINESE("[^a-zA-Z0-9\\u4E00-\\u9FA5]"),

    MULTI_LINE(""),


    ;

    private final String regEx;

    RegexMode(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}
