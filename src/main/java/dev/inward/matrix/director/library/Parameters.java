package dev.inward.matrix.director.library;

import java.util.Arrays;

public class Parameters implements Comparable<Parameters> {

    protected final String[] parameters;

    public Parameters(String[] parameters) {
        this.parameters = parameters;
    }
    @Override
    public int compareTo(Parameters o) {
        return Arrays.compare(this.parameters, o.parameters);
    }
}
