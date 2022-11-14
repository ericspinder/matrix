package dev.inward.matrix.fact.matter.warrant.why;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.sanction.Sanction;

import java.time.Instant;
import java.util.UUID;

public abstract class Why<W extends Why<W,CI,CX,S>,CI extends Identity<CI,CX>,CX extends Context<CX>,S extends Sanction<?, CI, CX,?>> extends Matter<CI, CX,M> {

    private S sanction;

    public Why(UUID uuid, CI subjectId, Instant createInstant, Indicia indicia, S sanction) {
        super(uuid,subjectId,createInstant, indicia);
        this.sanction = sanction;
    }

}
