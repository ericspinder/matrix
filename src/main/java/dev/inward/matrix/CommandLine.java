package dev.inward.matrix;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLine {

    protected Map<String,String> keyValues = new HashMap<>();
    protected List<String> unmatchedList = new ArrayList<>();

    public CommandLine(String args) {
        StringTokenizer stringTokenizer = new StringTokenizer(args);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (token.indexOf('=') != -1) {
                String[] keyValue = token.split("=");
                keyValues.put(keyValue[0],keyValue[1]);
            }
            unmatchedList.add(token);
        }
    }
    public String getValue(String key) {
        return this.keyValues.get(key);
    }
    public Set<Matcher> getMatched(String regex_s) {
        Set<Matcher> matched = new HashSet();
        Pattern regex = Pattern.compile(regex_s);
        for(String unmatched: unmatchedList) {
            Matcher matcher = regex.matcher(unmatched);
            matched.add(matcher);
        }
        return matched;
    }
}