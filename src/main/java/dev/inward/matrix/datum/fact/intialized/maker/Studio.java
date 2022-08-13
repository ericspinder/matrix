package dev.inward.matrix.datum.fact.intialized.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.datum.fact.intialized.Manager;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Studio<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Manager<Studio<M,IS,XS>,M,Scheduler<M,IS,XS>, Identity.Ego, Context.JVM,Scratch<M,IS,XS>, Observer<M,IS,XS>,Assembly,Corpus,Mechanical,Sandbox,Prophet> {


    public Studio(Prophet mortal, Resources resources, Map<Standard<?, M, Identity.Ego, Context.JVM>, Resource<Studio<M, IS, XS>, ?, ?, ?, M, Scheduler<M, IS, XS>, Identity.Ego, Context.JVM, Scratch<M, IS, XS>, Observer<M, IS, XS>>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
