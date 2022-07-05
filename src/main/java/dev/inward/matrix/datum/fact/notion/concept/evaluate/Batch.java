package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Specification;

public class Batch extends Effect<Bakery,Evaluate,Batch, Context.Service,Calc,Existent> {
    public Batch(Specification specification, Context.Service context) {
        super(specification, context);
    }
}
