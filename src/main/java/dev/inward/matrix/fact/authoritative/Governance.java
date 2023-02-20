 package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.personality.Personality;

import java.security.CodeSource;

 public abstract class Governance<N extends Notion<N,VERSION,V,ID,EXPIRE,G,A>,VERSION extends Comparable<VERSION>,V extends Identity.Versioned<VERSION,V,ID,G>,ID extends Comparable<ID>, EXPIRE extends Comparable<EXPIRE>,G extends Governance<N,VERSION,V,ID,EXPIRE,G>> extends Context<N,V,ID,G> {

    protected final Reaper<EXPIRE,?,?> reaper;

    public Governance(Variant variant, Personality personality, Industry<?,N,V,> industry, Tree[] trees, Zone zone) {
        super(variant, personality, factory, trees, zone);
        this.reaper = factory.getEngine().getOperational().specification().getStandards(zone));
    }

    public static class Ethereal<EXPIRE extends Comparable<EXPIRE>> extends Governance<EXPIRE,Ethereal<EXPIRE>> {
        public Ethereal(Variant variant,
                        Personality personality,
                        Factory factory,
                        Tree[] trees, Zone zone, Reaper<EXPIRE,?,?> reaper) {
            super(variant,personality,factory, trees,zone,reaper);
        }
    }
}
