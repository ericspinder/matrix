/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import java.time.Instant;

public class Bout<TARGET> {

    protected final Instant startDateTime = Instant.now();
    protected final TARGET target;

    public Bout(TARGET target) {
        this.target = target;
    }

    public TARGET getDatum() {
        return target;
    }

}
