package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.library.ProtectionDomainStorage;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class Resource<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {

    protected final ReferenceQueue<DATUM> referenceQueue;
    protected final ProtectionDomainStorage protectionDomainStorage;

    /**
     * @noinspection Intellij
     */
    public Resource(ProtectionDomainStorage protectionDomainStorage) {
        this.referenceQueue = new ReferenceQueue<>();
        this.protectionDomainStorage = protectionDomainStorage;
    }

    public ReferenceQueue<DATUM> getReferenceQueue() {
        return this.referenceQueue;
    }

    public ProtectionDomainStorage getBook() {
        return this.protectionDomainStorage;
    }



}
