package dev.inward.matrix;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;

import java.lang.invoke.CallSite;
import java.nio.file.attribute.FileAttributeView;
import java.util.concurrent.locks.StampedLock;

public abstract class Aspect<DATUM> implements Meta_I {

    protected final String label;
    protected final String description;
    protected final Resource<DATUM> resource;
    protected transient final CallSite callSite;

    public Aspect(String label, String description, CallSite callSite, Resource<DATUM> resource) {
        this.label = label;
        this.description = description;
        this.callSite = callSite;
        this.resource = resource;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}

