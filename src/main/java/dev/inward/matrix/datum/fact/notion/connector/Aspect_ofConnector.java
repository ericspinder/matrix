package dev.inward.matrix.datum.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.Boot;
import dev.inward.matrix.datum.fact.notion.concept.boot.Root;
import dev.inward.matrix.operational.Specification;

public class Aspect_ofConnector extends Aspect<Industry_forConnector,Connector,Aspect_ofConnector, Identity.Ego<Context.JVM>,Context.JVM, Omnibus_forConnector, Ambassador_holdingConnector, Boot, Root> {

    public Aspect_ofConnector(Specification specification, Context.JVM context) {
        super(specification, context);
    }
}
