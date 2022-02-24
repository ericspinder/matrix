package com.notionds.dataSupplier.rubric;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.subject.Matter;
import com.notionds.dataSupplier.subject.Subject;

import java.time.Instant;
import java.util.UUID;

public abstract class Corollary<I extends Id<I,X>,X extends Context<X>,T extends Criterion<?,?,?,?,?,I,X,?,?>,M extends Corollary<I,X,T,M>> extends Matter<I,M> {

    public Corollary(UUID uuid, I topicId, Instant createInstant, Subject subject) {
        super(uuid, topicId, createInstant, subject);
    }

    public abstract void process(T finished);

}
