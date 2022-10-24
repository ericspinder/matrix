package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Indicia;

import java.lang.ref.SoftReference;
import java.time.Instant;
import java.util.UUID;

public abstract class Sanction<S extends Sanction<S, CI, CX, NI, NX,R>,CI extends Identity<CI, CX>,CX extends Context<CX>,NI extends Identity<NI, NX>, NX extends Context<NX>,R extends Regulator<CI, CX, NI, NX>> extends Matter<S, CI, CX> {

//    private final Indicia DefaultSanction = new Indicia(this.getClass().getCanonicalName(), Indicia.Focus.Regulatory, Indicia.Severity.Privilege);
    private final SoftReference<R> regulator;
    public Sanction(UUID uuid, CI subjectId, Instant createInstant, Indicia indicia, R regulator) {
        super(uuid, subjectId, createInstant, indicia);
        this.regulator = new SoftReference<>(regulator);
    }

}
