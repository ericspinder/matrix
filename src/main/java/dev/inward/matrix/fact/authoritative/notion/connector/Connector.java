package dev.inward.matrix.fact.authoritative.notion.connector;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.phenomenon.producer.promise.Promise;

public abstract class Connector<RESP extends Matter<RESP,IC,XC>,REQ extends Matter<REQ,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Notion<Connector<?,?,?,?>,Identity.Ego, Context.Demarc> {

    public Connector(Identity.Ego id) {
        super(id);
    }


    public abstract Promise<>

}