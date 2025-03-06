/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.phenomenon;

import dev.inward.crud.Bus;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.Library;
import dev.inward.matrix.Model;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.file.addressed.http.Fact;
import dev.inward.matrix.file.addressed.log.Matter;

import java.util.concurrent.Callable;

public class Phenomenon<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,F extends Fact<S,L,PATH,F>,O extends Model<S,L,PATH,F,O>,M extends Matter<S,L,PATH,M>> implements Callable<M> {

    protected final AddressedKey.Query query;
    protected final O model;
    protected final Bus<S,L,PATH,F> bus;

    protected Phenomenon(O model,Bus<S,L,PATH,F> bus) {
        this.model = model;
        this.bus = bus;
    }

    @SuppressWarnings("unchecked")
    public M call() {
        return model.doit((P)this);
    }

}
