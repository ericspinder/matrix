package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;


public final class Construct extends Fabrication<Construct,Matrix,Interface, Context.Service,Loader,Architect> {
    public Construct(Progenitor progenitor, LinkedBlockingDeque<Interface> operationalDeque, Map<Class<?>, List<Predictor<Construct, ?, Matrix, Interface, Identity.SuperEgo<Context.Service>, Context.Service, Loader, Architect, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }
}
