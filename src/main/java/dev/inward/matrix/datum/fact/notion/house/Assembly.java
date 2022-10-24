package dev.inward.matrix.datum.fact.notion.house;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Mechanical;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Sandbox;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.datum.Standard;

import java.lang.invoke.MethodHandle;
import java.util.Map;

public class Assembly<A extends Assembly<A,H,M,S,P>,H extends House<H,P>,M extends Mechanical<A,H,M,S,P>,S extends Sandbox,P extends Prophet<H,P>> extends Industry<A,H,M,Identity.Ghost,Context.Ethereal,S,P> {

    public Assembly(Prophet mortal, Storage storage, Map<Standard<?, Corpus, Identity.Ego, Context.Demarc>, Resource<Assembly, ?, ?, ?, Corpus, Mechanical, Identity.Ego, Context.Demarc, Sandbox, Prophet>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}

