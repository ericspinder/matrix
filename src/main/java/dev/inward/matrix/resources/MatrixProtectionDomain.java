package dev.inward.matrix.resources;

import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.authoritative.Authoritative;
import dev.inward.matrix.fact.authoritative.Security;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.personality.Personality;

import java.security.ProtectionDomain;

public class MatrixProtectionDomain<S extends Authoritative<S,I,X,VERSION,EXPIRE,Y>,I extends Identity<I,X>,X extends Context<X>,VERSION extends Comparable<VERSION>,EXPIRE extends Comparable<EXPIRE>,Y extends Security<VERSION,EXPIRE,Y>> extends ProtectionDomain {

    public MatrixProtectionDomain(Edition edition, Personality personality, Factory factory, Tree[] trees) {
        super(edition, personality, factory, trees);
    }


    public Edition getEdition() {
        return (Edition) this.getCodeSource();
    }

}
