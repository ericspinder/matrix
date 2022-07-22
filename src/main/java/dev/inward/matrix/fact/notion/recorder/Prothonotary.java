package dev.inward.matrix.fact.notion.recorder;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Ambassador;
import dev.inward.matrix.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;


public class Prothonotary extends Ambassador<Press,Recorder<?,?,?,?>,Desk, Identity.Ego, Context.JVM,Journal, Prothonotary> {

    public Prothonotary(Recorder<?, ?, ?, ?> fact, ReferenceQueue<Recorder<?, ?, ?, ?>> referenceQueue, Journal omnibus, Desk aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}

