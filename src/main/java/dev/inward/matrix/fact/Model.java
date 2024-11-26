package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.Aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Model<PATH extends Comparable<PATH>,X extends Context<PATH,X,ID,I,C,R>,ID extends Comparable<ID>,I extends Concept.Identity<PATH,X,ID,I,C,R>,C extends Concept<PATH,X,ID,I,C,R>,R extends Representitive<PATH,X,ID,I,C,R>> {

    protected final Map<String,Aspect<?>> labeledAspects = new ConcurrentHashMap<>();

    public Model(Aspect<?>[] labeledAspects) {
        for (Aspect<?> aspect: labeledAspects) {
            this.labeledAspects.put(aspect.getLabel(),aspect);
        }
    }

    public Map<String, Aspect<?>> getLabeledAspects() {
        return labeledAspects;
    }
}