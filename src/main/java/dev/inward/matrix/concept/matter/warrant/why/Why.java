package dev.inward.matrix.concept.matter.warrant.why;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.sanction.Sanction;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Why<W extends Why<W,CI,CX,S>,CI extends Identity<CI,CX>,CX extends Context<CX>,S extends Sanction<?, CI, CX,?>> extends Matter<CI, CX,M> {

    private S sanction;

    public Why(UUID uuid, CI subjectId, Instant createInstant, Indicia indicia, S sanction) {
        super(uuid,subjectId,createInstant, indicia);
        this.sanction = sanction;
    }

}
