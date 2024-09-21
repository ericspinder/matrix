package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.Notion;

import java.util.UUID;

public class Dream extends Notion<Dream> {

    public Dream(Identity.Gate<S, L, PATH, N> id) {
        super(id);
    }

    @Override
    public Identity.Rule<UUID> getIdentity() {
        return null;
    }

    @Override
    public int compareTo(Identity.Rule<UUID> o) {
        return 0;
    }
}
