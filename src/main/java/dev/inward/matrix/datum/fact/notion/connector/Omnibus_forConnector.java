package dev.inward.matrix.datum.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.Boot;
import dev.inward.matrix.datum.fact.notion.concept.boot.Root;

public class Omnibus_forConnector extends Omnibus<Industry_forConnector,Connector,Aspect_ofConnector, Identity.Ego<Context.JVM>, Context.JVM,Omnibus_forConnector, Ambassador_holdingConnector, Boot, Root> {
    public Omnibus_forConnector(Aspect_ofConnector operational) {
        super(operational);
    }
}
