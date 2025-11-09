/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.Context;

import java.lang.ref.Reference;

public abstract class File<F extends File<F,K,V,M,O,L,C>,K extends FileKey<F,K,V,M,O,L,C>,V extends FileView<F,K,V,M,O,L,C>,M extends FileModel<F,K,V,M,O,L,C>,O extends OmniBus<F,K,V,M,O,L,C>,L extends Librarian<F,K,V,M,O,L,C>,C extends Context<F,K,V,M,O,L,C>>  {

    protected final K key;

    protected File(K key) {
        this.key = key;
    }

    public K getKey() {
        return this.key;
    }

    public L getLibrarian() {
        return ((C)this.getClass().getProtectionDomain()).getLibrarian();
    }

}
