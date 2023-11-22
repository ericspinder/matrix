package dev.inward.matrix.fact.authoritative.notion.concept.evaluate;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.Fabrication;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public class Bakery extends Fabrication<Bakery,Evaluate,Batch,Calc,Existent> {

    public Bakery(Existent mortal, Storage storage, Map<Standard<?, Evaluate, Identity.Ego, Context.Demarc>, Resource<Bakery, ?, ?, ?, Evaluate, Batch, Identity.Ego, Context.Demarc, Calc, Existent>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }

}
