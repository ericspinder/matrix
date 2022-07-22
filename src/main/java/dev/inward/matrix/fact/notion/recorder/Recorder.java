package dev.inward.matrix.fact.notion.recorder;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;

public abstract class Recorder<RESP extends Matter<I,X,RESP>,REQ extends Matter<I,X,REQ>,I extends Identity<I,X>,X extends Context<X>> extends Notion<Recorder<?,?,?,?>,Identity.Ego, Context.JVM> {

    public Recorder(Identity.Ego id) {
        super(id);
    }

    public abstract RESP process(REQ matter);

}
