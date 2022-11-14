package dev.inward.matrix.fact.notion.concept.corpus;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.notion.house.Assembly;
import dev.inward.matrix.fact.notion.house.House;
import dev.inward.matrix.fact.notion.house.Steward;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.resources.Supplier;

public class Mechanical<A extends Assembly<A,H,M,S,P>,H extends House<H,P>,M extends Mechanical<A,H,M,S,P>,S extends Sandbox<>,P extends Steward<H,P>> extends Aspect<A, H,Identity.Ghost,Context.Ethereal,Mechanical,S, P> {


    public Mechanical(Zone zone, Specification<House, Context.Ethereal, Mechanical> specification, Supplier supplier) {
        super(zone, specification, supplier);
    }
}
