/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.fact.addressed.dns;

import dev.inward.matrix.concept.fact.FactKey;
import dev.inward.matrix.concept.fact.addressed.AddressedKey;

import java.net.URI;
import java.util.UUID;

public class RRKey<F extends ResourceRecord<F,K,V,M,R,L>,K extends RRKey<F,K,V,M,R,L>,V extends RRView<F,K,V,M,R,L>,M extends RRModel<F,K,V,M,R,L>,R extends RRReference<F,K,V,M,R,L>,L extends RRLibrarian<F,K,V,M,R,L>> extends AddressedKey<F,K,V,M,R,L> {

    protected final UUID uuid;
    protected final boolean randomUUID;
    protected RRKey(URI uri, UUID uuid,boolean randomUUID) {
        super(uri);
        this.uuid = uuid;
        this.randomUUID = randomUUID;
    }

    public boolean isRandomUUID() {
        return randomUUID;
    }

    public static abstract class Builder<F extends ResourceRecord<F,K,V,M,R,L>,K extends RRKey<F,K,V,M,R,L>,V extends RRView<F,K,V,M,R,L>,M extends RRModel<F,K,V,M,R,L>,R extends RRReference<F,K,V,M,R,L>,L extends RRLibrarian<F,K,V,M,R,L>> extends FactKey.Builder<F,K,V,M,R,L> {

        protected UUID uuid;
        protected boolean randomUUID;

        public Builder<F,K,V,M,R,L> setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder<F,K,V,M,R,L> setRandomUUID(boolean isRandomUUID) {
            this.randomUUID = isRandomUUID;
            return this;
        }
    }

}
