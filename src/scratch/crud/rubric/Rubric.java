/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.rubric;

import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.fact.authoritative.notion.*;
import dev.inward.matrix.Context;
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
