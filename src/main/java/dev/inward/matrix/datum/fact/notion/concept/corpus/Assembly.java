package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Assembly extends Fabrication<Assembly, Corpus,Mechanical,Sandbox,Prophet> {

    public Assembly(Prophet mortal, Resources resources, Map<Standard<?, Corpus, Identity.Ego, Context.JVM>, Resource<Assembly, ?, ?, ?, Corpus, Mechanical, Identity.Ego, Context.JVM, Sandbox, Prophet>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
