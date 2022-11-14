package dev.inward.matrix.fact.notion.house;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.fact.notion.concept.corpus.Mechanical;
import dev.inward.matrix.fact.notion.concept.corpus.Sandbox;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.datum.Standard;

import java.util.Map;

public class Assembly<A extends Assembly<A,H,M,S,P>,H extends House<H,P>,M extends Mechanical<A,H,M,S,P>,S extends Sandbox,P extends Steward<H,P>> extends Industry<A,H,M,Identity.Ghost,Context.Ethereal,S,P> {

    public Assembly(Steward mortal, Storage storage, Map<Standard<?, Corpus, Identity.Ego, Context.Demarc>, Resource<Assembly, ?, ?, ?, Corpus, Mechanical, Identity.Ego, Context.Demarc, Sandbox, Steward>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}

