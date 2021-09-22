package dev.inward.fact;

import dev.inward.morph.CreationMorph;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode
public abstract class Fact implements Comparable<Fact>, Serializable {

    //private CreationMorph creationMorph;

    @Override
    public int compareTo(Fact o) {
        return 0;
    }
}
