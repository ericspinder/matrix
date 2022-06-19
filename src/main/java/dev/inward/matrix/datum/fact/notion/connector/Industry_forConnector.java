package dev.inward.matrix.datum.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.Boot;
import dev.inward.matrix.datum.fact.notion.concept.boot.Root;

import java.util.Map;

public class Industry_forConnector extends Industry<Industry_forConnector,Connector,Aspect_ofConnector,Identity.Ego<Context.JVM>,Context.JVM,Omnibus_forConnector, Ambassador_holdingConnector, Boot, Root> {


    public Industry_forConnector(Ambassador_holdingConnector primogenitor, Map<Class<?>, Resource<Industry_forConnector, ?, ?, ?, Connector, Aspect_ofConnector, Identity.Ego<Context.JVM>, Context.JVM, Omnibus_forConnector, Ambassador_holdingConnector, Connector, Ambassador_holdingConnector>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }

}
