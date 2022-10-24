package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Matter<MAT extends Matter<MAT, CI, CX>, CI extends Identity<CI,CX>,CX extends Context<CX>> implements Comparable<MAT>, Serializable {

    protected final UUID uuid;
    protected final CI containerId;
    protected final Instant createInstant;
    protected final Indicia indicia;
    protected final Situation situation = new Situation();

    public Matter(UUID uuid, CI containerId, Instant createInstant, Indicia indicia, ) {
        this.uuid = uuid;
        this.containerId = containerId;
        this.createInstant = createInstant;
        this.indicia = indicia;
    }
    @Override
    public int compareTo(MAT that) {
        int result = this.indicia.compareTo(indicia);
        if (result == 0) {
            return this.uuid.compareTo(uuid);
        }
        return result;
    }

    public final UUID getUuid() {
        return uuid;
    }
    public final CI getContainerId() {
        return this.containerId;
    }
    public final Instant getCreateInstant() {
        return this.createInstant;
    }
    public final Indicia getIndica() {
        return indicia;
    }


}
