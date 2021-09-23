package dev.inward.fact;

import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode
public abstract class Fact<F extends Fact<?>> implements Comparable<F>, Serializable {

    @Override
    public int compareTo(F o) {
        return 0;
    }
}
