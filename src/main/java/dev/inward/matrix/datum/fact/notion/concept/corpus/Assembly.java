package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class Assembly extends Fabrication<Assembly, Corpus,Mechanical,Sandbox,Prophet> {

    public Assembly(Prophet mortal, Storage storage, Map<Standard<?, Corpus, Identity.Ego, Context.Ethereal>, Resource<Assembly, ?, ?, ?, Corpus, Mechanical, Identity.Ego, Context.Ethereal, Sandbox, Prophet>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
