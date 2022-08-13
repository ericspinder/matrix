package dev.inward.matrix.operational.induction;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;

public class Resource<DATUM,D extends Datum<DATUM,D,E,I,X>,E extends Envoy<DATUM,D,E,I,X>,F extends Fact<F,I,X,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> {

    protected final ReferenceQueue<DATUM> referenceQueue;


    /**
     * @noinspection Intellij
     */
    public Resource(NotionProtectionDomain notionProtectionDomain) {
        this.referenceQueue = new ReferenceQueue<>();
        this.notionProtectionDomain = notionProtectionDomain;
    }

    public ReferenceQueue<DATUM> getReferenceQueue() {
        return this.referenceQueue;
    }

    public NotionProtectionDomain getBook() {
        return this.notionProtectionDomain;
    }
}
