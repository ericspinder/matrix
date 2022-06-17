package dev.inward.matrix.meta;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.DatumVisitor;


public class Standard<DATUM,F extends Fact<F,I,X,?>,I extends Identity<I,X>,X extends Context<X>> {

    protected String objectClassName;
    protected Criteria<DATUM,?,?,F,I,X,?,?,?,?> criteria;

    public Standard(final String objectClassName, Criteria<DATUM,?,) {
    }

    public String getObjectClassName() {
        return objectClassName;
    }
}
