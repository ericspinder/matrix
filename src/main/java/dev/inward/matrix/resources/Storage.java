package dev.inward.matrix.resources;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.*;

import java.util.HashMap;
import java.util.Map;

public class Storage<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Fact.Resource<N,I,X,A,I,X> {

    protected final MatrixProtectionDomain<Y,N,S,I,X,O,A> matrixProtectionDomain;
    protected final Map<String, Resource> standardResourcesMap = new HashMap<>();

    public Storage(MatrixProtectionDomain<Y, N, S, I, X, O, A> matrixProtectionDomain, Map<Standard, Resource> standardResourcesMap) {
        this.matrixProtectionDomain = matrixProtectionDomain;
        this.standardResourcesMap = standardResourcesMap;
    }

}
