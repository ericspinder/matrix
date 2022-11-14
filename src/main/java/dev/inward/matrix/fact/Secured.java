package dev.inward.matrix.fact;

import dev.inward.matrix.engine.Expire;
import dev.inward.matrix.engine.Version;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.personality.Personality;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.security.PermissionCollection;

public class Secured<S extends Secured<S,I,X,VERSION,V,E>,I extends Identity<I,X>,X extends Context<X>,VERSION extends Comparable<VERSION>,V extends Version<VERSION,V,E>,E extends Expire<VERSION,V,E>> extends Tracked<S,I,X,VERSION,V,E>{

    protected final Personality<?,?,X,?> personality;
    protected f
    public Secured(I identity, V version, E expire,Personality<?,?,X,?> personality) {
        super(identity, version, expire);
        this.personality = personality;
    }
}
