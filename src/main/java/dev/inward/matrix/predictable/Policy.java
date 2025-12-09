/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.concept.fact.addressed.depot.indica.Indica;
import dev.inward.matrix.concept.fact.addressed.log.Log;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;


public abstract class Policy<TARGET, L extends Log> implements Function<Bout<TARGET>,L> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Indica indica;
    protected final Criterion criterion;

    public Policy(Indica indica, Criterion criterion) {
        this.indica = indica;
        this.criterion = criterion;
    }

    /**
     * Processes the given bout and generates a log describing the outcome.
     *
     * @param bout the bout instance containing the target and associated data to process. May be used to share data among sister policies.
     * @return a log instance that captures the outcome of processing the given bout, if needed, null when processed without comment.
     */
    public abstract Log process(Bout<TARGET> bout);
    public UUID getUUID() {
        return uuid;
    }
    public Indica getIndicia() {
        return indica;
    }
    public Criterion getCriterion() {
        return criterion;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that instanceof Policy<?,?> policy) {
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
