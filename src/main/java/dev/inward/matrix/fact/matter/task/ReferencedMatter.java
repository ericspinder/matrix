package dev.inward.matrix.fact.matter.task;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Context;

import java.lang.ref.SoftReference;

public class ReferencedMatter<RM extends Matter<RM,I,X>,I extends Identity<I,X>,X extends Context<X>> extends SoftReference<RM> {

    public ReferencedMatter(RM referent) {
        super(referent);
    }
}

