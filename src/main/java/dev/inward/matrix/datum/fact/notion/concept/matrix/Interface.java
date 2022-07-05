package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

public class Interface extends Effect<Construct,Matrix,Interface,Loader,Architect> {

    public Interface(Specification specification, Supplier<Construct,Matrix,Interface, Identity.Ego,Context.JVM,Loader,Architect,Matrix,Architect> supplier) {
        super(specification, supplier);
    }
}
