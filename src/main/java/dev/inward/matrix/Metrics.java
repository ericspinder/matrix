package dev.inward.matrix;

import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.log.Matter;

import java.time.Instant;

public abstract class Metrics<H extends Comparable<H>,M extends Metrics<H,M,G>,G extends Identity.Individual<G>> extends Matter<M,G> {

    protected volatile H happiness;
    public Metrics(G id, Instant createInstant, Indicia indicia, boolean settled, H happiness) {
        super(id,indicia,createInstant,settled);
        this.happiness = happiness;
    }
    public void setHappiness(H happiness)  {
        if (!this.settled) {
            this.happiness = happiness;
        }
    }
    public H getHappiness() {
        return this.happiness;
    }
}
