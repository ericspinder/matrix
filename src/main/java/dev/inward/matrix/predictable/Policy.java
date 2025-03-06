/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.*;
import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.file.addressed.log.Matter;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;



public abstract class Policy<K extends MatrixKey<K,I>,I extends MatrixItem<K,I>,M extends Matter> implements Runnable {

    protected final UUID uuid = UUID.randomUUID();
    protected final Complication<K,I> complication;
    protected final Indica indica;
    protected final PolicyCriterion<K,I,M> policyCriterion;
    protected M currentMatter;

    public Policy(Complication<K,I> complication, Indica indica, PolicyCriterion<K,I,M> policyCriterion) {
        this.complication = complication;
        this.indica = indica;
        this.policyCriterion = policyCriterion;
    }

    public final void run() {
        if (currentMatter == null) {
            this.policyCriterion.createNewMatter(complication.matrixKey);
        }
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that instanceof Policy<?,?,?> policy) {
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
