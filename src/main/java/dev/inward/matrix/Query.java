package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;

public class Query<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,Q extends Query<S,L,PATH,ID,Q>> implements Addressed<S,L,PATH,ID,Identity.Ethereal<S,L,PATH,ID,Q>,Q> {

    protected final Identity.Ethereal<S,L,PATH,ID,Q> identity;

    public Query(Identity.Ethereal<S,L,PATH,ID,Q> identity) {
        this.identity = identity;
    }
    @Override
    public Identity.Ethereal<S,L,PATH,ID,Q> getIdentity() {
        return this.identity;
    }

    @Override
    public int compareTo(Identity.Ethereal<S, L, PATH, ID, Q> that) {
        return this.identity.id.compareTo(that.id);
    }
}
