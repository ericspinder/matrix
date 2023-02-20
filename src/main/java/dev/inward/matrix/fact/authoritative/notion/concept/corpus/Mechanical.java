package dev.inward.matrix.fact.authoritative.notion.concept.corpus;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.fact.authoritative.notion.house.Assembly;
import dev.inward.matrix.fact.authoritative.notion.house.House;
import dev.inward.matrix.fact.authoritative.notion.house.Steward;
import dev.inward.matrix.resources.Supplier;

public class Mechanical<A extends Assembly<A,H,M,S,P>,H extends House<H,P>,M extends Mechanical<A,H,M,S,P>,S extends Sandbox<>,P extends Steward<H,P>> extends Aspect<A, H,Identity.Ghost, Governance.Ethereal,Mechanical,S, P> {


    public Mechanical(Zone zone, Specification<House, Governance.Ethereal, Mechanical> specification, Supplier supplier) {
        super(zone, specification, supplier);
    }
}
