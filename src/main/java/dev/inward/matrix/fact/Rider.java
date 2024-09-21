package dev.inward.matrix.fact;

import dev.inward.matrix.Dogma;
import dev.inward.matrix.Pathway;
import dev.inward.matrix.fact.datum.Ware;

import java.io.IOException;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Rider<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>,R extends Rider<PATH,P,ID,T,C,R>> extends Ware<C,R> implements Rider.MatrixFileView {

    public interface MatrixFileView extends AclFileAttributeView {
        Instant getUpdateTime();
        Expire getExpire();
    }
    protected Instant updateTime;
    protected Expire expire;
    private volatile C held;
    public Rider(C concept, Concept.Resource<PATH,P,ID,T,C> resource, boolean hold) {
        super(UUID.randomUUID(), concept, resource);
        if (hold) {
            this.held = concept;
        }
        else {
            this.held = null;
        }
        this.updateTime = Instant.now();
    }

    @Override
    public List<AclEntry> getAcl() throws IOException {
        return this.get().identity.pathway.;
    }

    @Override
    public Dogma.Agent getOwner() throws IOException {
        return null;
    }

    @Override
    public void setOwner(UserPrincipal owner) throws IOException {
        throw new UnsupportedOperationException();
    }

    public boolean release() {
        if (held != null) {
            this.held = null;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isHeld() {
        return this.held != null;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public Instant setThenReturnUpdateTime() {
        this.updateTime = Instant.now();
        return this.updateTime;
    }

    @Override
    public boolean enqueue() {
        this.held = null;
        return super.enqueue();
    }
}
