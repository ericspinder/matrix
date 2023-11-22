package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.Identity;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.personality.Personality;

import java.security.CodeSource;
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
