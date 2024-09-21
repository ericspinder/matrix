package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;

import java.lang.invoke.CallSite;
import java.nio.file.attribute.FileAttributeView;
import java.util.concurrent.locks.StampedLock;

public abstract class Aspect<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>> implements FileAttributeView {

    protected StampedLock gate = new StampedLock();

    protected final String name;
    protected final Fact.Resource<S,L,PATH,ID,T,C> resource;
    protected transient final CallSite callSite;

    public Aspect(String name, CallSite callSite, Fact.Resource<S,L,PATH,ID,T,C> resource) {
        this.name = name;
        this.callSite = callSite;
        this.resource = resource;
    }

    @Override
    public String name() {
        return this.name;
    }

    public Rider<S,L,PATH,ID,T,C> getRepresentative() {
        long writeLock = gate.writeLock();
        try {
            C value = this.value();
            if (value != null) {
                return new Rider<>(value,this.resource);
            }
            return null;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

}

