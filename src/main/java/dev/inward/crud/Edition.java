package dev.inward.crud;

import dev.inward.matrix.info.Dogma;
import dev.inward.matrix.operation.Concept;
import dev.inward.matrix.http.Fact;

public abstract class Edition<SERIAL extends Comparable<SERIAL>,N extends Fact.Identity<N,E,M>,E extends Edition<SERIAL,N,E,M>,M extends Edition.Model<SERIAL,N,E,M>> extends Fact<N,E,M> {

    public static class Model<SERIAL extends Comparable<SERIAL>,N extends Identity<N,E,M>,E extends Edition<SERIAL,N,E,M>,M extends Edition.Model<SERIAL,N,E,M>> extends dev.inward.matrix.Model<N,E,M> {


        public Model(Concept.Identity.Id<S, L, N, F, M> id, Aspect<S, L, String, String, N, F>[] aspects) {
            super(id, aspects);
        }

        @Override
        public Dogma userInfo() {
            return null;
        }

        @Override
        public int compareTo(M o) {
            return 0;
        }
    }
    protected final SERIAL serial;
    public Edition(N identity, SERIAL serial) {
        super(identity);
        this.serial = serial;
    }

    public SERIAL getSerial() {
        return serial;
    }

}
