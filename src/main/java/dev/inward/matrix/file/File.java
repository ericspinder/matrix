/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.file.directory.*;

public abstract class File<F extends File<F,K,V,M,R,L>,K extends FileKey<F,K,V,M,R,L>,V extends FileView<F,K,V,M,R,L>,M extends FileModel<F,K,V,M,R,L>,R extends FileReference<F,K,V,M,R,L>,L extends FileLibrarian<F,K,V,M,R,L>> implements Datum<F,V,M,R,L> {

    protected final K key;

    protected File(K key) {
        this.key = key;
    }

    public K getKey() {
        return this.key;
    }

    @Override
    public R getReference() {
        return this.key.reference;
    }

}
