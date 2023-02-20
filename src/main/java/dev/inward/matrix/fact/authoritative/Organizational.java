package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.personality.Personality;

import java.security.CodeSource;

public abstract class Organizational<O extends Organizational<O,A,I,ID,VERSION,X,EXPIRE>,A extends Authoritative<A,I,ID,VERSION,X,EXPIRE>,I extends Identity<I,ID,VERSION,X>,ID extends Comparable<ID>,VERSION extends Comparable<VERSION>,X extends Governance<VERSION,X,EXPIRE>,EXPIRE extends Comparable<EXPIRE>,R extends Regulated> extends Factory<O,A,I,ID,VERSION,X,R> {

    protected EXPIRE expire;
    public Organizational(CodeSource codesource, Personality personality, Factory<?,?,?,?,VERSION,X,?> factory, Tree[] trees, Domain domain, InternetClass internetClass, Zone zone, Variant variant, VERSION version, EXPIRE expire) {
        super(codesource, personality, factory, trees, domain, internetClass, zone, variant, version);
        this.expire = expire;
    }
}
