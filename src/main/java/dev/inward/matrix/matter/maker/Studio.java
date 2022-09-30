package dev.inward.matrix.matter.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.datum.fact.intialized.Manager;
import dev.inward.matrix.standard.Standard;

import java.util.Map;

public class Studio<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Manager<Studio<M,IS,XS>,M,Scheduler<M,IS,XS>, Identity.Ego, Context.Ethereal,Scratch<M,IS,XS>, Observer<M,IS,XS>,Assembly,Corpus,Mechanical,Sandbox,Prophet> {


    public Studio(Prophet mortal, Resources resources, Map<Standard<?, M, Identity.Ego, Context.Ethereal>, Resource<Studio<M, IS, XS>, ?, ?, ?, M, Scheduler<M, IS, XS>, Identity.Ego, Context.Ethereal, Scratch<M, IS, XS>, Observer<M, IS, XS>>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
