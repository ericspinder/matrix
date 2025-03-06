/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.rubric;

import dev.inward.matrix.engine.Edition;
import crud.Protocol;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.datum.Standard;

import java.security.KeyStore;
import java.util.Map;

public class Prescript<C extends Protocol<C,X,?>,X extends Context.Platform<X>,E extends Edition<E,X>> extends Rubric<C, Identity.Ego<X>,X,E> {

    private final KeyStore keyStore;

    public Prescript(String conceptClassName, Map<String, Standard<?>> standards,E edition, KeyStore keyStore) {
        super(conceptClassName, standards, edition);
        this.keyStore = keyStore;
    }


}
