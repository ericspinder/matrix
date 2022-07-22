package dev.inward.matrix.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Fabrication;
import dev.inward.matrix.meta.Standard;

import java.util.Map;


public final class Construct extends Fabrication<Construct,Matrix,Interface,Loader,Architect> {

    public Construct(Architect mortal, Resources resources, Map<Standard<?, Matrix, Identity.Ego, Context.JVM>, Resource<Construct, ?, ?, ?, Matrix, Interface, Identity.Ego, Context.JVM, Loader, Architect>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
