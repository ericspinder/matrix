package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Matter;
import dev.inward.matrix.matter.Promise;

public abstract class Connector<RESP extends Matter<RESP,IC,XC>,REQ extends Matter<REQ,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Notion<Connector<?,?,?,?>,Identity.Ego,Context.JVM> {

    public Connector(Identity.Ego id) {
        super(id);
    }


    public abstract Promise<>

}