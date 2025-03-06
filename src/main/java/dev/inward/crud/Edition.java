/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud;

import dev.inward.matrix.file.addressed.http.Fact;
import dev.inward.matrix.file.addressed.info.UserName;
import dev.inward.matrix.operation.Concept;

public abstract class Edition<SERIAL extends Comparable<SERIAL>,N extends Fact.AddressedKey<N,E,M>,E extends Edition<SERIAL,N,E,M>,M extends Edition.Model<SERIAL,N,E,M>> extends Fact<N,E,M> {

    public static class Model<SERIAL extends Comparable<SERIAL>,N extends AddressedKey<N,E,M>,E extends Edition<SERIAL,N,E,M>,M extends Edition.Model<SERIAL,N,E,M>> extends dev.inward.matrix.Model<N,E,M> {


        public Model(Concept.Identity.Id<S, L, N, F, M> id, Aspect<S, L, String, String, N, F>[] aspects) {
            super(id, aspects);
        }

        @Override
        public UserName userInfo() {
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
