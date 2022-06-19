package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;

import java.util.Map;


public final class Construct extends Fabrication<Construct,Matrix,Interface,Loader,Architect> {

    public Construct(Architect primogenitor, Map<Class<?>, Resource<Construct, ?, ?, ?, Matrix, Interface, Identity.Ego, Context.Service, Loader, Architect>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }
}
