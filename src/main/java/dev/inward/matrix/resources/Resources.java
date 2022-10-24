package dev.inward.matrix.resources;

import dev.inward.matrix.clues.Policy;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.house.House;

public class Resources<F extends Fact<F,I,X,R,NI,NX>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>> extends Resource<F> {

    protected final House ziggurat;

    public Resources(House house, Policy[] policies) {
        super(policies);
        this.ziggurat = house;
    }

}
