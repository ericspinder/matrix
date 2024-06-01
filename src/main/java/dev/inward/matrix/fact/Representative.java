package dev.inward.matrix.fact;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.resources.Contrivance;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;

import java.time.Instant;

public class Representative<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Envoy<C,Representative<S,L,PATH,ID,T,C>,S,L,PATH,ID,T,C> {

    protected final Instant createTime;
    private volatile C held;
    public Representative(C concept, Contrivance<S,L,PATH,ID,T,C,?,?> parentStorage, boolean hold, Instant createTime) {
        super(concept, parentStorage);
        if (hold) {
            this.held = concept;
        }
        else {
            this.held = null;
        }
        this.createTime = createTime;
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

    public Instant getCreateTime() {
        return createTime;
    }
}
