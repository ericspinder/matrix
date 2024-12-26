package dev.inward.matrix;

import dev.inward.matrix.*;
import dev.inward.matrix.Aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Model {

    protected final Map<String,Aspect> labeledAspects = new ConcurrentHashMap<>();

    public Model(Aspect[] labeledAspects) {
        for (Aspect aspect: labeledAspects) {
            this.labeledAspects.put(aspect.getLabel(),aspect);
        }
    }

    public Map<String, Aspect> getLabeledAspects() {
        return labeledAspects;
    }
}