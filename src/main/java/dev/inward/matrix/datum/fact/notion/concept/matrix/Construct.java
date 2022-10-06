package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.standard.Standard;

import java.util.Map;


public final class Construct extends Fabrication<Construct,Matrix,Interface,Loader,Architect> {

    public Construct(Architect mortal, Storage storage, Map<Standard<?, Matrix, Identity.Ego, Context.Ethereal>, Resource<Construct, ?, ?, ?, Matrix, Interface, Identity.Ego, Context.Ethereal, Loader, Architect>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
