package dev.inward.matrix.datum.fact.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.phenomenon.producer.communications.ThreadedConcept;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Matter<MAT extends Matter<MAT,I,X>,I extends Identity<I,X>,X extends Context<X>> extends Fact<MAT, Identity.Ego, Context.Ethereal> implements Comparable<MAT>, Serializable {

    protected final I containerId;
    protected final Instant createInstant;
    protected final Indicia indicia;
    protected final ThreadedConcept threadedConcept = new ThreadedConcept();

    public Matter(Identity.Ego ego, I containerId, Instant createInstant, Indicia indicia) {
        super(ego);
        this.containerId = containerId;
        this.createInstant = createInstant;
        this.indicia = indicia;
    }
    @Override
    public int compareTo(MAT that) {
        int result = this.indicia.compareTo(indicia);
        if (result == 0) {
            return super.compareTo(that);
        }
        return result;
    }

    public final I getContainerId() {
        return this.containerId;
    }
    public final Instant getCreateInstant() {
        return this.createInstant;
    }
    public final Indicia getIndica() {
        return indicia;
    }


}
