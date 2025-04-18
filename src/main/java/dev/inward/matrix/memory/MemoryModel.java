/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;

public abstract class MemoryModel<B extends MemoryLibrarian<B,K,I,V,M,R,T>,K extends MemoryKey<B,K,I,V,M,R,T>,I extends Memory<B,K,I,V,M,R,T>,V extends MemoryView<B,K,I,V,M,R,T>,M extends MemoryModel<B,K,I,V,M,R,T>,R extends MemoryReference<B,K,I,V,M,R,T>,T extends MemoryLibrarian<B,K,I,V,M,R,T>> extends Model<I> {
    public MemoryModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
