package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Options;

public class Batch extends Effect<Bakery,Evaluate,Batch, Context.Service,Calc,Existent> {
    public Batch(Options options, Context.Service context) {
        super(options, context);
    }
}
