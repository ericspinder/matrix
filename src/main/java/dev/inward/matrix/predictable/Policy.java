/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.*;
import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.file.addressed.log.Log;

import java.util.Objects;
import java.util.UUID;


public abstract class Policy<TARGET> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Indica indica;
    protected final Criterion<TARGET> criterion;
    protected M currentMatter;

    public Policy(Complication<TARGET> complication, Indica indica, Criterion<TARGET> criterion) {
        this.indica = indica;
        this.criterion = criterion;
    }

    public abstract Log process(Bout<TARGET> bout);

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that instanceof Policy<?,?,?,?,?,?,?,?,?,?,?> policy) {
            int isZero = this.getClass().getCanonicalName().compareTo(policy.getClass().getCanonicalName());
            if (isZero == 0) {
                return this.uuid.compareTo(policy.uuid) == 0;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.uuid);
    }

}
