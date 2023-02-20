package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.personality.Personality;

import java.security.CodeSource;

public class Dream<VERSION extends Comparable<VERSION>,D extends Dream<VERSION,D,EXPIRE>,EXPIRE extends Comparable<EXPIRE>> extends Governance<VERSION,D,EXPIRE> {
    public Dream(CodeSource codesource, Personality personality, Factory factory, Tree[] trees, Domain domain, InternetClass internetClass, Zone zone, Variant variant, VERSION version, EXPIRE expire) {
        super(codesource,personality,factory, trees,domain,internetClass,zone,variant,version,expire);
    }
}
