package dev.inward.matrix.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.boot.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Agency extends Industry<Agency,Connector, Journey,Identity.Ego,Context.JVM, Passage, Agent, BootLoader,Boot, Init, Structure,Root> {


    public Agency(Root mortal, Resources resources, Map<Standard<?, Connector, Identity.Ego, Context.JVM>, Resource<Agency, ?, ?, ?, Connector, Journey, Identity.Ego, Context.JVM, Passage, Agent>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
