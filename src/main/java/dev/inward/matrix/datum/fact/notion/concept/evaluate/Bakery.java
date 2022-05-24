package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;

import java.util.Map;

public class Bakery extends Fabrication<Bakery,Evaluate,Batch,Context.Service,Calc,Existent> {

    public Bakery(Existent primogenitor, Map<Class<?>, Resources<Bakery,?,?,?,Evaluate,Batch,Identity.Ego<Context.Service>,Context.Service,Calc,Existent,Evaluate,Existent>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }
}
