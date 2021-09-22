package dev.inward.fact;

import dev.inward.morph.CreationMorph;



public class Criterion<G extends CriterionGate> extends Fact {

    private G gate;

    public Criterion(CreationMorph creationMorph) {
        super(creationMorph);
    }

}
