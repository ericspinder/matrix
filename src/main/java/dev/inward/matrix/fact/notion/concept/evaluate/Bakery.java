package dev.inward.matrix.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Fabrication;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Bakery extends Fabrication<Bakery,Evaluate,Batch,Calc,Existent> {

    public Bakery(Existent mortal, Resources resources, Map<Standard<?, Evaluate, Identity.Ego, Context.JVM>, Resource<Bakery, ?, ?, ?, Evaluate, Batch, Identity.Ego, Context.JVM, Calc, Existent>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }

}
