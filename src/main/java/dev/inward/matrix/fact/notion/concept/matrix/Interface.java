package dev.inward.matrix.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.Effect;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Interface extends Effect<Construct,Matrix,Interface,Loader,Architect> {

    public Interface(Specification specification, Supplier<Construct, Matrix, Interface, Identity.Ego, Context.JVM, Loader, Architect, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
