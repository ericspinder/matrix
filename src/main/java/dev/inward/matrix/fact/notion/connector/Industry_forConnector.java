package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.boot.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Industry_forConnector extends Industry<Industry_forConnector,Connector,Aspect_ofConnector,Identity.Ego,Context.JVM,Omnibus_forConnector, Ambassador_holdingConnector, BootLoader,Boot, Init, Structure,Root> {


    public Industry_forConnector(Root mortal, Resources resources, Map<Standard<?, Connector, Identity.Ego, Context.JVM>, Resource<Industry_forConnector, ?, ?, ?, Connector, Aspect_ofConnector, Identity.Ego, Context.JVM, Omnibus_forConnector, Ambassador_holdingConnector>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
