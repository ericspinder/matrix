package dev.inward.matrix.fact.authoritative.notion.authority.matrix;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.Fabrication;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;


public final class Construct extends Fabrication<Construct,Matrix, Interface_2,Loader,Architect> {

    public Construct(Architect mortal, Storage storage, Map<Standard<?, Matrix, Identity.Ego, Context.Demarc>, Resource<Construct, ?, ?, ?, Matrix, Interface_2, Identity.Ego, Context.Demarc, Loader, Architect>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
