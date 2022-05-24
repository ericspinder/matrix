package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

public class Interface extends Effect<Construct,Matrix,Interface, Context.Service,Loader,Architect> {

    public Interface(Options options, Supplier<Construct, Matrix, Interface, Identity.Ego<Context.Service>, Context.Service, Loader, Architect, Matrix, Architect> supplier) {
        super(options, supplier);
    }
}
