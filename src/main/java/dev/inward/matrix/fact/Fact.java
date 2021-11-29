package dev.inward.matrix.fact;

import dev.inward.matrix.Addressable;

public abstract class Fact<UM extends Fact<UM>> implements Addressable<UM> {

    @Override
    public int compareTo(UM o) {
        return 0;
    }
}
