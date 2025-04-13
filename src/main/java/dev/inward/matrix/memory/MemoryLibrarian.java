/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory;

import dev.inward.matrix.Librarian;

public class MemoryLibrarian<B extends MemoryLibrarian<B,I,V,M,R,T>,I extends Memory<B,I,V,M,R,T>,V extends MemoryView<B,I,V,M,R,T>,M extends MemoryModel<B,I,V,M,R,T>,R extends MemoryReference<B,I,V,M,R,T>,T extends MemorySteward<B,I,V,M,R,T>> extends Librarian<B,I,V,M,R,T> {

    protected MemoryLibrarian(T steward) {
        super(steward);
    }
}
