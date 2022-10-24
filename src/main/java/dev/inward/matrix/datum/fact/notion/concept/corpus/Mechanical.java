package dev.inward.matrix.datum.fact.notion.concept.corpus;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.datum.fact.notion.house.Assembly;
import dev.inward.matrix.datum.fact.notion.house.House;
import dev.inward.matrix.datum.fact.notion.house.Prophet;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Mechanical<A extends Assembly<A,H,M,S,P>,H extends House<H,P>,M extends Mechanical<A,H,M,S,P>,S extends Sandbox<>,P extends Prophet<H,P>> extends Aspect<A, H,Identity.Ghost,Context.Ethereal,Mechanical,S, P> {


    public Mechanical(Zone zone, Specification<House, Context.Ethereal, Mechanical> specification, Supplier supplier) {
        super(zone, specification, supplier);
    }
}
