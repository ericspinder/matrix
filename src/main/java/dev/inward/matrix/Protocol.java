package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Indicia;

import java.util.HashMap;
import java.util.Map;

public abstract class Protocol<PATH extends Comparable<PATH>> {

    private static final Map<String,Protocol<?>> KnownProtocols = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <PATH extends Comparable<PATH>> Protocol<PATH> GetProtocol(String protocol) {
        return (Protocol<PATH>) KnownProtocols.get(protocol.toLowerCase());
    }

    protected final String protocol;

    public Protocol(String protocol) {
        this.protocol = protocol.toLowerCase();
        KnownProtocols.put(protocol, this);
    }

    public String getProtocol() {
        return protocol;
    }

    public static class Info extends Protocol<String> {

        public Info() {
            super("info");
        }
    }

    public static class Log extends Protocol<Indicia> {

        public Log() {
            super("log");
        }
    }

    public static class HTML extends Protocol<String> {

        public HTML() {
            super("html");
        }
    }
    public static class SSL extends Protocol<String> {

        public SSL() {
            super("ssl");
        }
    }

    public static class Tree extends Protocol<Branch> {

        public Tree() {
            super("tree");
        }
    }

}
