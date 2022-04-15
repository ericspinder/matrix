package com.notionds.jdbc;

import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.Supervisor;

public class Omnibus_forConnector extends Omnibus<Connector,Omnibus_forConnector> {
    public Omnibus_forConnector(Supervisor supervisors) {
        super(supervisors);
    }
}
