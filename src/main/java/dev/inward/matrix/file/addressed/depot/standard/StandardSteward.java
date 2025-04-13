/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.standard;

import dev.inward.matrix.file.addressed.depot.DepotSteward;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class StandardSteward extends DepotSteward<StandardLibrarian,StandardKey,Standard,StandardView,StandardModel,StandardReference, StandardSteward> {
    public StandardSteward(Function<StandardReference, StandardReference> graveDigger, StandardModel model, Class<StandardView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
