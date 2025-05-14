/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.standard;

import dev.inward.matrix.file.addressed.depot.DepotLibrarian;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class StandardLibrarian extends DepotLibrarian<Standard,StandardKey,StandardView,StandardModel,StandardReference,StandardLibrarian> {

    public StandardLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
