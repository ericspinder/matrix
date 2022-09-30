package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class BootLoader extends Fabrication<BootLoader,Boot,Init,Structure,Root> {

    public BootLoader(Root mortal, Resources resources, Map<Standard<?, Boot, Identity.Ego, Context.Ethereal>, Resource<BootLoader, ?, ?, ?, Boot, Init, Identity.Ego, Context.Ethereal, Structure, Root>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}