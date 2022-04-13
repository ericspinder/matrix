package dev.inward.matrix.house;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;

import java.io.Serializable;

public class House<H extends House<H,L,I>,L extends Factory<L>,I extends Identity<L,I, Context<L>>> implements Comparable<H>, Serializable, Identity.Addressable<L,I, Context<L>> {

    protected final I ego;
    protected final L library;

    public House(I ego, L library) {
        this.ego = ego;
        this.library = library;
    }

    @Override
    public int compareTo(H that) {
        return that.ego.compareTo(that.ego);
    }

    @Override
    public I getId() {
        return this.ego;
    }
    public L getLibrary() {
        return this.library;
    }
}
