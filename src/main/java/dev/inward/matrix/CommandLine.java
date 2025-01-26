package dev.inward.matrix;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLine {

    protected Map<String,String> keyedStringValues = new HashMap<>();
    protected List<String> unmatchedStringList = new ArrayList<>();

    public CommandLine(String args) throws IOException {

        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(args));
        tokenizer.resetSyntax();
        tokenizer.wordChars(' ', 255);
        tokenizer.whitespaceChars(0, ' ');
        tokenizer.parseNumbers();
        tokenizer.quoteChar('"');
        tokenizer.quoteChar('\'');
        tokenizer.commentChar('#');
        tokenizer.eolIsSignificant(true);

        String unmatchedInput = null;
        boolean hangingEquals = false;
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (tokenizer.ttype == StreamTokenizer.TT_EOL) {
                hangingEquals = false;
                if (unmatchedInput != null && !unmatchedInput.isBlank()) {
                    unmatchedStringList.add(unmatchedInput);
                }
            }
            if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                String token = tokenizer.sval;
                int pos =  token.indexOf('=');
                if (pos > 0) {
                    String[] keyValue = token.split("=");
                    keyedStringValues.put(keyValue[0], keyValue[1]);
                    continue;
                }
                if (pos == 0) {
                    if (token.length() > 1) {
                        if (unmatchedInput != null) {
                            keyedStringValues.put(unmatchedInput, token.substring(1));
                            unmatchedInput = null;
                        }
                        else {
                            unmatchedStringList.add(token);
                        }
                    }
                    else {
                        hangingEquals = true;
                    }
                    continue;
                }
                else {
                    if (unmatchedInput != null) {
                        if (hangingEquals) {
                            keyedStringValues.put(unmatchedInput, token);
                            unmatchedInput = null;
                        }
                        else {
                            unmatchedStringList.add(token);
                        }
                    }
                    else {
                        unmatchedInput = token;
                    }
                }
            }
        }
        System.out.println("unable to parse: " + tokenizer.toString());
    }
    public String getValue(String key) {
        return this.keyedStringValues.get(key);
    }
    public Set<Matcher> getMatched(String regex_s) {
        Set<Matcher> matched = new HashSet<>();
        Pattern regex = Pattern.compile(regex_s);
        for(String unmatched: unmatchedStringList) {
            Matcher matcher = regex.matcher(unmatched);
            matched.add(matcher);
        }
        return matched;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommandLine{");
        sb.append("keyedStringValues=[");
        Iterator<String> keyIt = keyedStringValues.keySet().iterator();
        while (keyIt.hasNext()) {
            String key = keyIt.next();
            sb.append(key).append(" = ").append(keyedStringValues.get(key));
            if (keyIt.hasNext()) {
                sb.append(',');
            }
        }

        sb.append(", unmatchedStringList=").append(unmatchedStringList);
        sb.append('}');
        return sb.toString();
    }
}