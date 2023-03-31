package dev.inward.matrix.route;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.Concept;

import java.util.BitSet;
import java.util.UUID;

public class Driver<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>,D extends Driver<F,I,ID,X, D>> extends Thread implements Comparable<D>, Passage {

    protected volatile BitSet passage;

    public Driver(Concept concept) {
        super();
        passage = PassagePresets.NEW.getPassage();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Concept getConcept() {
        return concept;
    }

    @Override
    public BitSet getPassage() {
        return passage;
    }

    @Override
    public int compareTo(D o) {
        return 0;
    }
}
