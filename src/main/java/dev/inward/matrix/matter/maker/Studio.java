package dev.inward.matrix.matter.maker;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.house.Assembly;
import dev.inward.matrix.datum.fact.notion.house.Steward;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.datum.fact.intialized.Manager;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public class Studio<M extends Maker<M,?,?,?,?,?,?,?,?>,IS extends Identity<IS,XS>,XS extends Context<XS>> extends Manager<Studio<M,IS,XS>,M,Scheduler<M,IS,XS>, Identity.Ego, Context.Demarc,Scratch<M,IS,XS>, Observer<M,IS,XS>, Assembly,Corpus,Mechanical,Sandbox, Steward> {


    public Studio(Steward mortal, Storage storage, Map<Standard<?, M, Identity.Ego, Context.Demarc>, Resource<Studio<M, IS, XS>, ?, ?, ?, M, Scheduler<M, IS, XS>, Identity.Ego, Context.Demarc, Scratch<M, IS, XS>, Observer<M, IS, XS>>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
