package dev.inward.matrix.fact.notion.recorder;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.*;
import dev.inward.matrix.fact.notion.concept.corpus.*;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Press extends Industry<Press,Recorder<?,?,?,?>,Desk, Identity.Ego, Context.JVM,Journal, Prothonotary, Assembly, Corpus, Mechanical, Sandbox, Prophet> {


    public Press(Prophet mortal, Resources resources, Map<Standard<?, Recorder<?, ?, ?, ?>, Identity.Ego, Context.JVM>, Resource<Press, ?, ?, ?, Recorder<?, ?, ?, ?>, Desk, Identity.Ego, Context.JVM, Journal, Prothonotary>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
