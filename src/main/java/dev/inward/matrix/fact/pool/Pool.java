package dev.inward.matrix.fact.pool;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.Ambassador;
import dev.inward.matrix.fact.notion.concept.Context;

public class Pool<I extends Identity<I,X>,X extends Context<X>> extends Fact<Pool<I,X>,I,X> {

    public Pool(I id) {
        super(id);
    }
}

