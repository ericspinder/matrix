package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;

import java.util.Map;


public final class Construct extends Fabrication<Construct,Matrix,Interface, Context.Service,Loader,Architect> {

    public Construct(Architect primogenitor, Map<Class<?>, Resources<Construct, ?, ?, ?, Matrix, Interface, Identity.Ego<Context.Service>, Context.Service, Loader, Architect, Matrix, Architect>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }
}
