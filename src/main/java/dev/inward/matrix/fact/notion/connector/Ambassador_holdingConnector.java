package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Ambassador;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.boot.Boot;
import dev.inward.matrix.fact.notion.concept.boot.Root;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Ambassador_holdingConnector extends Ambassador<Industry_forConnector,Connector,Aspect_ofConnector, Identity.Ego,Context.JVM, Omnibus_forConnector,Ambassador_holdingConnector> {


    public Ambassador_holdingConnector(Connector fact, ReferenceQueue<Connector> referenceQueue, Omnibus_forConnector omnibus, Aspect_ofConnector aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
