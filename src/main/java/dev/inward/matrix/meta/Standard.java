package dev.inward.matrix.meta;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Criteria;


public class Standard<DATUM,F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>> {


    protected String datumClassName;
    protected Criteria<DATUM,F,I,X>[] criteria;

    public Standard(final String datumClassName, Criteria<DATUM,F,I,X>[] criteria) {
        this.datumClassName = datumClassName;
        this.criteria = criteria;
    }

    public String getDatumClassName() {
        return datumClassName;
    }
}
