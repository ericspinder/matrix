/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.variant.Variant;
import dev.inward.matrix.file.addressed.info.Agent;
import dev.inward.matrix.file.addressed.info.House;
import dev.inward.matrix.personality.Personality;

import java.security.Principal;
import java.security.ProtectionDomain;

public abstract class Context<DATUM,V extends View<DATUM,V,M,R,B>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,B>,B extends Librarian<DATUM,V,M,R,B>> extends ProtectionDomain {

    public Context(Variant variant, Personality personality, Factory<PATH,X,ID,I,C,R> factory, Agent owner, House group, @Nullable F parent) {
        super(variant,personality,factory,new Principal[] {owner,group});
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    public Variant getVariant() {
        return (Variant) this.getCodeSource();
    }
    @SuppressWarnings("unchecked")
    public Personality getPersonality() {
        this.getCodeSource()
        return (Personality)this.getPermissions();
    }
    @SuppressWarnings("unchecked")
    public Factory<PATH,ID,I,A,R,F> getFactory() {
        return (Factory<PATH,X,ID,I,C,R>) this.getClassLoader();
    }

    public abstract F getAuthority();

}
