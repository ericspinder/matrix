package crud;

import dev.inward.matrix.Terrene;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.Fact;

import java.util.UUID;

public abstract class Protocol<P extends Protocol<P,S,L>,S extends Scheme<P,S,L>,L extends Library<P,S,L>> extends Fact<P,S,L, UUID,String, Identity.Ego<P,S,L>, Context> {

    protected final S scheme;
    protected final Daemon daemon;

    public Protocol(Identity.Ego<P,S,L> id, S scheme, Terrene terrene) {
        super(id);
        this.scheme = scheme;
        this.terrene = terrene;
    }

    public String getScheme() {
        return scheme;
    }

    public Terrene getTerrene() {
        return terrene;
    }

}

