package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.resources.Resources;

import java.lang.invoke.CallSite;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.locks.StampedLock;

public abstract class Aspect<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> implements FileAttribute<C> {

    protected StampedLock gate = new StampedLock();

    protected final String name;
    protected final Resources<S,L,PATH,ID,T,C> resources;
    protected transient final CallSite callSite;

    public Aspect(String name, CallSite callSite, Resources<S,L,PATH,ID,T,C> resources) {
        this.name = name;
        this.callSite = callSite;
        this.resources = resources;
    }

    @Override
    public String name() {
        return this.name;
    }

    public Representative<S,L,PATH,ID,T,C> getRepresentative() {
        long writeLock = gate.writeLock();
        try {
            C value = this.value();
            if (value != null) {
                return new Representative<>(value,this.resources);
            }
            return null;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

}

