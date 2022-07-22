package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;

public class Connector extends Notion<Connector, Identity.Ego,Context.JVM, Ambassador_holdingConnector> {
    public Connector(Identity.Ego id) {
        super(id);
    }
}
