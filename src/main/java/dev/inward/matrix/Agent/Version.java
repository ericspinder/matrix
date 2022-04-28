package dev.inward.matrix.Agent;

public class Version {

    public static final Version Aforementioned = new Version(".1"); // can't call it 'this'

    private final String version;
    public Version(String version) {
        this.version = version;
    }
}
