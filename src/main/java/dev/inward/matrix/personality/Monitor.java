/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.personality;

import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.file.addressed.depot.indica.IndicaKey;
import dev.inward.matrix.file.addressed.log.Log;

import java.time.Instant;

public abstract class Monitor<S extends Scheme<S,L>,L extends Authority<S,L>,PATH extends Comparable<PATH>,N extends Notion<S,L,PATH,N>,M extends Log<S,L,PATH,N,M>> {

    protected final IndicaKey<S,L,PATH,N> indicaKey;
    protected final Instant createTime = Instant.now();

    protected Monitor(IndicaKey<S,N,PATH,N> indicaKey) {
        this.indicaKey = indicaKey;
    }

    protected abstract IndicaKey<S,N,PATH,N> operate(String item, ITEM oldItem);
}
