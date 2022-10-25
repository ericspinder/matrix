package dev.inward.matrix.datum.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Boot;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Init;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Root;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.*;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public class Agency extends Industry<Agency,Connector, Journey,Identity.Ego, Context.Demarc, Passage, Agent, Boot, dev.inward.matrix.datum.fact.notion.concept.boot.Boot, Init, Structure, Root> {

    public Agency(Root mortal, Storage storage, Map<Standard<?, Connector, Identity.Ego, Context.Demarc>, Resource<Agency, ?, ?, ?, Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
