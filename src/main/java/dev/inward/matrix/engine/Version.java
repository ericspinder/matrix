package dev.inward.matrix.engine;

public abstract class Version<VERSION extends Comparable<VERSION>,V extends Version<VERSION,V>> implements Comparable<V> {

    protected VERSION version;

    public Version(VERSION version) {
        this.version = version;
    }

    public VERSION getVersion() {
        return version;
    }

    @Override
    public int compareTo(V that) {
        return this.version.compareTo(that.version);
    }

    public static class StringVersion extends Version<String,StringVersion> {

        public StringVersion(String s) {
            super(s);
        }
    }

}
