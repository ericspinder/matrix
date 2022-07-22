package dev.inward.matrix.fact.notion.recorder;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Omnibus;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;

public class Journal extends Omnibus<Press,Recorder<?,?,?,?>,Desk, Identity.Ego, Context.JVM,Journal, Prothonotary> {

    public Journal(Desk operational) {
        super(operational);
    }
}
