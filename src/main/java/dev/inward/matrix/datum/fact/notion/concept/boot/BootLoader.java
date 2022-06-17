package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.Agent.Startup;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class BootLoader extends Fabrication<BootLoader,Boot,Init,Structure,Root> {

    public BootLoader(Root primogenitor, Map<Standard<?,Boot,Identity.Ego,Context.JVM>, Resources<BootLoader,?,?,?,Boot,Init,Identity.Ego,Context.JVM,Structure,Root>> classResourceMap) {
        super(primogenitor, classResourceMap);
    }
}