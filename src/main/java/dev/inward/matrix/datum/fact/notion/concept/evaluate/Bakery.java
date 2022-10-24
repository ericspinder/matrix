package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public class Bakery extends Fabrication<Bakery,Evaluate,Batch,Calc,Existent> {

    public Bakery(Existent mortal, Storage storage, Map<Standard<?, Evaluate, Identity.Ego, Context.Demarc>, Resource<Bakery, ?, ?, ?, Evaluate, Batch, Identity.Ego, Context.Demarc, Calc, Existent>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }

}
