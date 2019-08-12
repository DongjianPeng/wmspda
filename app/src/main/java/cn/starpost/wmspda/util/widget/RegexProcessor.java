package cn.starpost.wmspda.util.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexProcessor {

    private final static ConcurrentHashMap<RegexMode, Pattern> patterns = new ConcurrentHashMap<>();

    private static Pattern getPattern(RegexMode config) {
        Pattern pattern = null;
        if (patterns.contains(config)) {
            pattern = patterns.get(config);
        } else {
            pattern = Pattern.compile(config.getRegEx());
            patterns.put(config, pattern);
        }
        return pattern;
    }

    /**
     * 会返回所选正则匹配的第一个结果
     *
     * @param config
     * @param originContent
     * @return
     */
    public static String matcherFirst(RegexMode config, String originContent) {
        Pattern pattern = getPattern(config);
        Matcher matcher = pattern.matcher(originContent);
        String group = matcher.group();
        return group;
    }

    /**
     * 会返回所选正则匹配的所有结果
     *
     * @param config
     * @param originContent
     * @return
     */
    public static List<String> matchers(RegexMode config, String originContent) {
        Pattern pattern = getPattern(config);
        Matcher matcher = pattern.matcher(originContent);
        String group = matcher.group();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < matcher.groupCount(); i++) {
            result.add(matcher.group(i));
        }
        return result;
    }

    /**
     * 会替换掉所选的正则并返回替换后的内容
     *
     * @param config
     * @param originContent
     * @return
     */
    public static String replaceAll(RegexMode config, String originContent) {
        Pattern pattern = getPattern(config);
        Matcher matcher = pattern.matcher(originContent);
        return matcher.replaceAll("");
    }
}
