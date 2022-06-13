package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.Agent.Platform;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;

import java.util.Map;

public class BootLoader extends Fabrication<BootLoader,Boot,Init,Structure,Root> {

    protected final Platform agent;

    public BootLoader(Root primogenitor, Map<Class<?>, Resources<BootLoader,?,?,?,Boot,Init,Identity.Ego<Context.JVM>,Context.JVM,Structure,Root,Boot,Root>> classResourceMap, Platform agent) {
        super(primogenitor, classResourceMap);
        this.agent = agent;
    }
}