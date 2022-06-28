package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Memory;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Options;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Aspect<Y extends Industry<Y,N,S,I,X,O,A,?,?,?,?,?>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Ambassador<Y,N,S,I,X,O,A>> extends Operational<Y,N,S,I,X,O,A> {

    protected final Memory<Y, N, S, I, X, O, A> notionsInMemory = new Memory();

    public Aspect(Options options, Supplier<Y, N, S, I, X, O, A, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(options, supplier, protectionDomain);
    }
}

