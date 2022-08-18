package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.UUID;

public abstract class Sanction<S extends Sanction<S,I,X,IC,XC,R>,I extends Identity<I,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>,R extends Regulator<I,X,IC,XC>> extends Matter<S,I,X> {

//    private final Indicia DefaultSanction = new Indicia(this.getClass().getCanonicalName(), Indicia.Focus.Regulatory, Indicia.Severity.Privilege);
    private final SoftReference<R> regulator;
    public Sanction(UUID uuid, I subjectId, Instant createInstant, Indicia indicia, R regulator) {
        super(uuid, subjectId, createInstant, indicia);
        this.regulator = new SoftReference<>(regulator);
    }

}
