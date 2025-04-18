/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.engine;

import dev.inward.matrix.Librarian;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.operation.Concept;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Induction<DATUM,PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,D,ID,I,C>,C extends Concept<PATH,D,ID,I,C,R>,R extends AddressedReference<PATH,D,ID,I,C,R> {

    protected final DatumVisitor<DATUM> datumVisitor;
    protected final Librarian<DATUM,S,L,PATH,ID,I,C,N> steward;

    public Induction(@Nonnull Librarian<DATUM,S,L,PATH,ID,I,C,N> steward, @Nullable DatumVisitor<DATUM> datumVisitor) {
        this.steward = steward;
        if (datumVisitor != null) {
            datumVisitor = new DatumVisitor<DATUM>();
        }
    }
    public V engage(DATUM datum,R representative) {

    }

    public Librarian<DATUM> getResource() {
        return steward;
    }
}