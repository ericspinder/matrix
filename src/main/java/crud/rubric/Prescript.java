package crud.rubric;

import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Concept;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Standard;

import java.security.KeyStore;
import java.util.Map;

public class Prescript<C extends Concept<C,X,?>,X extends Context.Platform<X>,E extends Edition<E,X>> extends Rubric<C, Identity.Ego<X>,X,E> {

    private final KeyStore keyStore;

    public Prescript(String conceptClassName, Map<String, Standard<?>> standards,E edition, KeyStore keyStore) {
        super(conceptClassName, standards, edition);
        this.keyStore = keyStore;
    }


}
