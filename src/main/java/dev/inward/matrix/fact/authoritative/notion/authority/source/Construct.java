package dev.inward.matrix.fact.authoritative.notion.authority.source;

import dev.inward.matrix.authority.source.Source;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.Fabrication;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;


public final class Construct extends Fabrication<Construct, Source, Interface_2,Loader,Architect> {

    public Construct(Architect mortal, Storage storage, Map<Standard<?, Source, Identity.Ego, Context.Demarc>, Resource<Construct, ?, ?, ?, Source, Interface_2, Identity.Ego, Context.Demarc, Loader, Architect>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
