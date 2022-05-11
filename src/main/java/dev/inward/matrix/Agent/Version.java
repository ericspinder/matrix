package dev.inward.matrix.Agent;

public record Version(String version) {

    public static final Version Aforementioned = new Version(".1"); // can't call it 'this'

}
