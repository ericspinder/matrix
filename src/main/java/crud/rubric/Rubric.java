package crud.rubric;

import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.*;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Standard;

import java.util.Map;

public class Rubric<DATUM,N extends Notion<N,I,X,?>,I extends Identity<I,X>,X extends Context<X>,E extends Edition<E,X>> {

    protected final E edition;

    public Rubric(String notionClassName, Map<String, Standard<DATUM,N,I,X>> standard,E edition) {
        this.edition = edition;
    }
    public E getEdition() {
        return this.edition;
    }
}
