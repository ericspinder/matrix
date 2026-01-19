/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.Concept;

public interface Shadowed<TARGET, V extends View<TARGET, V, M>, M extends Model<TARGET, V, M>, C extends Concept<TARGET, V, M, C, X>, X extends Context<TARGET, V, M, C, X>> {
    Shadow<TARGET, V, M> getReference();

    void setReference(Shadow<TARGET, V, M> reference);
}
