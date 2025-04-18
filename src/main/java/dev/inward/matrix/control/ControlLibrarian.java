/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control;

import dev.inward.matrix.DatumLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class ControlLibrarian<I extends Control<I,V,M,R,B>,V extends ControlView<I,V,M,R,B>,M extends ControlModel<I,V,M,R,B>,R extends ControlReference<I,V,M,R,B>,B extends ControlLibrarian<I,V,M,R,B>> extends DatumLibrarian<I,V,M,R,B> {
    public ControlLibrarian(Standard standard) {
        super(standard);
    }
}
