package com.notionds.jdbc;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Connector extends Notion<Connector, Identity.Ego<Context.JVM>,Context.JVM,Primogenitor_holdingConnector> {
    public Connector(Identity.Ego<Context.JVM> id) {
        super(id);
    }
}
