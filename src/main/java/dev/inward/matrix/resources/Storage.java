package dev.inward.matrix.resources;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.authoritative.notion.*;
import dev.inward.matrix.fact.Context;

import java.util.HashMap;
import java.util.Map;

public class Storage<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Resources<N,I,X,A,I,X> {

    protected final MatrixProtectionDomain<Y,N,S,I,X,O,A> matrixProtectionDomain;
    protected final Map<String, Resource> standardResourcesMap = new HashMap<>();

    public Storage(MatrixProtectionDomain<Y, N, S, I, X, O, A> matrixProtectionDomain, Map<Standard, Resource> standardResourcesMap) {
        this.matrixProtectionDomain = matrixProtectionDomain;
        this.standardResourcesMap = standardResourcesMap;
    }

}
