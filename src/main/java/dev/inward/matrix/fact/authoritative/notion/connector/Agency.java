package dev.inward.matrix.fact.authoritative.notion.connector;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.boot.Structure;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat.Boot;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat.Init;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat.Root;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public class Agency extends Industry<Agency,Connector, Journey,Identity.Ego, Context.Demarc, Passage, Agent, Boot, dev.inward.matrix.fact.authoritative.notion.concept.boot.Boot, Init, Structure, Root> {

    public Agency(Root mortal, Storage storage, Map<Standard<?, Connector, Identity.Ego, Context.Demarc>, Resource<Agency, ?, ?, ?, Connector, Journey, Identity.Ego, Context.Demarc, Passage, Agent>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
