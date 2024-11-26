package dev.inward.matrix;

import java.time.Instant;

public class Experience {

    protected Instant lastUpdate = Instant.now();

    public Instant getLastUpdate() {
        return lastUpdate;
    }
    public void resetLastUpdate() {
        this.lastUpdate = Instant.now();
    }
}
