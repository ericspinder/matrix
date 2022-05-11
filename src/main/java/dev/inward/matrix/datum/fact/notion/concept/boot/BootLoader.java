package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.Agent.PlatformAgent;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;

import java.util.Map;

public class BootLoader extends Fabrication<BootLoader,Boot,Init,Context.JVM,Structure,Root> {

    protected final PlatformAgent agent;

    public BootLoader(Root primogenitor, Map<Class<?>,Resource<BootLoader,?,?,Boot,Init,Identity.Ego<Context.JVM>,Context.JVM,Structure,Root,Boot,Root,?>> classResourceMap, PlatformAgent agent) {
        super(primogenitor, classResourceMap);
        this.agent = agent;
    }
}