package dev.inward.matrix.concept.matter.task;

import dev.inward.matrix.Identity;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Context;

import java.lang.ref.SoftReference;

public class ReferencedMatter<RM extends Matter<RM,I,X>,I extends Identity<I,X>,X extends Context<X>> extends SoftReference<RM> {

    public ReferencedMatter(RM referent) {
        super(referent);
    }
}

