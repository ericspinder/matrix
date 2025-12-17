/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns;

public class RRReference<F extends ResourceRecord<F,K,V,M,R,B>,K extends RRKey<F,K,V,M,R,B>,V extends RRView<F,K,V,M,R,B>,M extends RRModel<F,K,V,M,R,B>,R extends RRReference<F,K,V,M,R,B>,B extends RRLibrarian<F,K,V,M,R,B>> implements dev.inward.matrix.Seat<F> {

    public RRReference(F referent, B librarian) {
        super(referent, librarian);
    }
}
