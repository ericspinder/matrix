package dev.inward.matrix.fact.notion.concept.matrix;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Fabrication;
import dev.inward.matrix.fact.datum.Standard;

import java.util.Map;


public final class Construct extends Fabrication<Construct,Matrix, Interface_2,Loader,Architect> {

    public Construct(Architect mortal, Storage storage, Map<Standard<?, Matrix, Identity.Ego, Context.Demarc>, Resource<Construct, ?, ?, ?, Matrix, Interface_2, Identity.Ego, Context.Demarc, Loader, Architect>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
