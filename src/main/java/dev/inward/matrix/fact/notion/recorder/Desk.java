package dev.inward.matrix.fact.notion.recorder;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.*;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;


public class Desk extends Aspect<Press,Recorder<?,?,?,?>,Desk, Identity.Ego, Context.JVM,Journal, Prothonotary> {

    public Desk(Specification specification, Supplier<Press, Recorder<?, ?, ?, ?>, Desk, Identity.Ego, Context.JVM, Journal, Prothonotary, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
