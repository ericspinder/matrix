/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot.standard;

import dev.inward.matrix.concept.fact.addressed.depot.DepotView;

public class StandardView extends DepotView<Standard,StandardKey,StandardView,StandardModel, StandardReference, StandardLibrarian> {

    public StandardView(String name, Standard file) {
        super(name, file);
    }
}
