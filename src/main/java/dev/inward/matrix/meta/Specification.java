package dev.inward.matrix.meta;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Zone;

import java.util.Map;

public class Specification<DATUM,F extends Fact<F,I,X,?>,I extends Identity<I,X>,X extends Context<X>> extends Standard<DATUM,F,I,X> {

    protected final Map<String,Standard<DATUM,F,I,X>> standards;
    protected Zone[] activeZones;

    public Specification(final String factClassName, Criteria<DATUM,?,?,F,I,X,?,?,?,?> criteria, final Map<String,Standard<DATUM,F,I,X>> standards) {
        super(factClassName,criteria);
        this.standards = standards;
    }

    public final Map<String,Standard<DATUM,F,I,X>> getStandards() {
        return this.standards;
    }
}
