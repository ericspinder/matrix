package dev.inward.matrix.fact.matter.sanction;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.authoritative.Regulator;
import dev.inward.matrix.fact.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Sanction<S extends Sanction<S, CI, CX, NI, NX,R>,CI extends Identity<CI, CX>,CX extends Context<CX>,NI extends Identity<NI, NX>, NX extends Context<NX>,R extends Regulator<CI, CX, NI, NX>> extends Matter<S, CI, CX> {

//    private final Indicia DefaultSanction = new Indicia(this.getClass().getCanonicalName(), Indicia.Focus.Regulatory, Indicia.Severity.Privilege);
    public Sanction(UUID uuid, CI subjectId, Instant createInstant, Indicia indicia) {
        super(uuid, subjectId, createInstant, indicia);
    }

}
