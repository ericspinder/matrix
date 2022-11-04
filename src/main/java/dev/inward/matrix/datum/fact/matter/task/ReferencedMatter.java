package dev.inward.matrix.datum.fact.matter.task;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;

import java.lang.ref.SoftReference;

public class ReferencedMatter<RM extends Matter<RM,I,X>,I extends Identity<I,X>,X extends Context<X>> extends SoftReference<RM> {

    public ReferencedMatter(RM referent) {
        super(referent);
    }
}

