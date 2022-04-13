package dev.inward.matrix.matter.warrant.why;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.matter.sanction.Sanction;

import java.time.Instant;
import java.util.UUID;

public abstract class Why<I extends Identity<I,X>,X extends Context<X>,S extends Sanction<?,I,X,?>,M extends Why<I,X,S,M>> extends Matter<I,X,M> {

    private S sanction;

    public Why(UUID uuid, I subjectId, Instant createInstant, Subject subject, S sanction) {
        super(uuid,subjectId,createInstant,subject);
        this.sanction = sanction;
    }

}
