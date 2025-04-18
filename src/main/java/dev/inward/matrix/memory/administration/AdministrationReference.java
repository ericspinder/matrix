/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.administration;

import dev.inward.matrix.memory.MemoryReference;

public abstract class AdministrationReference<B extends AdministrationLibrarian<B,K,I,V,M,R,T>,K extends AdministrationKey<B,K,I,V,M,R,T>,I extends Administration<B,K,I,V,M,R,T>,V extends AdministrationView<B,K,I,V,M,R,T>,M extends AdministrationModel<B,K,I,V,M,R,T>,R extends AdministrationReference<B,K,I,V,M,R,T>,T extends AdministrationLibrarian<B,K,I,V,M,R,T>> extends MemoryReference<B,K,I,V,M,R,T> {
    public AdministrationReference(A referent, G gestalt) {
        super(referent, gestalt);
    }
}
