package dev.inward.matrix.fact.notion;

import dev.inward.matrix.engine.Expire;
import dev.inward.matrix.engine.Version;
import dev.inward.matrix.fact.Tracked;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.concept.Context;

import java.time.Instant;

public abstract class Notion<N extends Notion<N,I,X,VERSION,V,E>,I extends Identity<I,X>,X extends Context<X>,VERSION extends Comparable<VERSION>,V extends Version<VERSION,V>,E extends Expire<VERSION,V,E>> extends Tracked<N,I,X,VERSION,V,E> {

    public Notion(I id, V version, E expire) {
        super(id,version,expire);
    }

}
