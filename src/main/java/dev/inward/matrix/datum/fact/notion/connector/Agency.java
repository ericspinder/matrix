package dev.inward.matrix.datum.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.*;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class Agency extends Industry<Agency,Connector, Journey,Identity.Ego,Context.JVM, Passage, Agent, BootLoader,Boot, Init, Structure,Root> {

    public Agency(Root mortal, Resources resources, Map<Standard<?, Connector, Identity.Ego, Context.JVM>, Resource<Agency, ?, ?, ?, Connector, Journey, Identity.Ego, Context.JVM, Passage, Agent>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
