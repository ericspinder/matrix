package dev.inward.matrix.fact.authoritative.notion.house;

import dev.inward.matrix.Standard;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Corpus;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Mechanical;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Sandbox;
import dev.inward.matrix.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public class Assembly<A extends Assembly<A,H,M,S,P>,H extends House<H,P>,M extends Mechanical<A,H,M,S,P>,S extends Sandbox,P extends Steward<H,P>> extends Industry<A,H,M,Identity.Ghost, Context.Ethereal,S,P> {

    public Assembly(Steward mortal, Storage storage, Map<Standard<?, Corpus, Identity.Ego, Context.Demarc>, Resource<Assembly, ?, ?, ?, Corpus, Mechanical, Identity.Ego, Context.Demarc, Sandbox, Steward>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}

