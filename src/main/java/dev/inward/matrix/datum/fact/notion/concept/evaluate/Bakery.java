package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class Bakery extends Fabrication<Bakery,Evaluate,Batch,Calc,Existent> {

    public Bakery(Existent mortal, Resources resources, Map<Standard<?, Evaluate, Identity.Ego, Context.JVM>, Resource<Bakery, ?, ?, ?, Evaluate, Batch, Identity.Ego, Context.JVM, Calc, Existent>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }

}
