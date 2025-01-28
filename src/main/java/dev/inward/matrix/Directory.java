package dev.inward.matrix;

public class Directory<PATH extends Comparable<PATH>> {

    protected final PATH path;

    public Directory(PATH path) {
        this.path = path;
    }
}
