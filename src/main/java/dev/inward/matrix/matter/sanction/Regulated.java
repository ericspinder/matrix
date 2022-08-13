package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class Regulated<I extends Identity<I,X>,X extends Context<X>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Representative<Regulator<I,X,IC,XC>,I,X,Regulated<I,X,IC,XC>,IC,XC> {

    public Regulated(Regulator<I, X, IC, XC> regulator, ReferenceQueue<Regulator<I, X, IC, XC>> referenceQueue, IC containerId) {
        super(regulator, referenceQueue, containerId);
    }
}
