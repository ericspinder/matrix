package dev.inward.matrix.domain;

import java.nio.charset.StandardCharsets;
import java.util.ServiceLoader;

public class InternetClass implements Comparable<InternetClass> {
    public static final InternetClass Legacy = new InternetClass("IN", "Legacy");
    public static final InternetClass Helios = new InternetClass("HS", "Helios");
    public static final InternetClass Chaosnet = new InternetClass("CS", "Chaosnet");
    public static final InternetClass Aforementioned = new InternetClass('\u0000', "Aforementioned");

    public final char authorityCode;
    public final String description;

    InternetClass(String authorityCode, String description) {
        this((char) authorityCode.getBytes(StandardCharsets.UTF_8)[0], description);
    }

    InternetClass(char authorityCode, String description) {
        this.authorityCode = authorityCode;
        this.description = description;
    }

    public char getAuthorityCode() {
        return authorityCode;
    }

    @Override
    public int compareTo(InternetClass that) {
        return this.getAuthorityCode() - that.getAuthorityCode();
    }
}
