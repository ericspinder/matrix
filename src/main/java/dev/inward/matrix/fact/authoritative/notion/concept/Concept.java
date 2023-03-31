package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;

import java.security.Principal;
import java.time.Instant;

public abstract class Concept<C extends Concept<C,ID>,ID extends Comparable<ID>> extends Fact<C, Instant, Identity.Ego,ID,Instant, Context.Ethereal> implements Principal {

    public Concept(Identity.Ego id) {
        super(id);
    }

    @Override
    public final String getName() {
        return getIdentity().getName(0).;
    }
}

