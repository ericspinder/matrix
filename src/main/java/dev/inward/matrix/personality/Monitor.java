/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.personality;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;
import dev.inward.matrix.file.addressed.log.Matter;

import java.time.Instant;

public abstract class Monitor<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,N extends Notion<S,L,PATH,N>,M extends Matter<S,L,PATH,N,M>> {

    protected final IndiciaKey<S,L,PATH,N> indiciaKey;
    protected final Instant createTime = Instant.now();

    protected Monitor(IndiciaKey<S,N,PATH,N> indiciaKey) {
        this.indiciaKey = indiciaKey;
    }

    protected abstract IndiciaKey<S,N,PATH,N> operate(String item, ITEM oldItem);
}
