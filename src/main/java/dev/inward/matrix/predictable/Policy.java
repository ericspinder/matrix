/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.*;
import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.file.addressed.log.Matter;

import java.util.Objects;
import java.util.UUID;


public abstract class Policy<PK extends MatrixKey<PK,PI,PV,PM,PR,PG>,PI extends MatrixItem<PK,PI,PV,PM,PR,PG>,PV extends View<PI,PM>,PM extends Model<PI>,PR extends Reference<PI,PV,PM,PR,PG>,PG extends Librarian<PI,PV,PM,PR,PG>, DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,G>,G extends Librarian<DATUM,V,M,R,G>> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Complication<PK,PI,PV,PM,PR,PG,DATUM,V,M,R,G> complication;
    protected final Indica indica;
    protected final Criterion<PK,PI,PV,PM,PR,PG,DATUM,V,M,R,G> criterion;
    protected M currentMatter;

    public Policy(Complication<PK,PI,PV,PM,PR,PG,DATUM,V,M,R,G> complication, Indica indica, Criterion<PK,PI,PV,PM,PR,PG,DATUM,V,M,R,G> criterion) {
        this.complication = complication;
        this.indica = indica;
        this.criterion = criterion;
    }

    public abstract Matter process(Bout<DATUM,V,M,R,G> bout);

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
