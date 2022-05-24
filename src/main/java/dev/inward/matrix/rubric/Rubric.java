package dev.inward.matrix.rubric;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.meta.Specification;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Rubric<DATUM,N extends Notion<N,I,X,?>,I extends Identity<I,X>,X extends Context<X>,E extends Edition<E,X>> extends Specification<DATUM,N,I,X> {

    protected final E edition;

    public Rubric(String notionClassName, Map<String, Standard<DATUM,N,I,X>> standards,E edition) {
        super(notionClassName, standards);
        this.edition = edition;
    }
    public E getEdition() {
        return this.edition;
    }
}
