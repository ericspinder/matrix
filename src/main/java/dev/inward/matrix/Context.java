/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.file.addressed.depot.variant.Variant;
import dev.inward.matrix.file.addressed.http.Fact;
import dev.inward.matrix.file.addressed.info.Agent;
import dev.inward.matrix.file.addressed.info.House;
import dev.inward.matrix.personality.Personality;

import javax.annotation.Nullable;
import java.security.Principal;
import java.security.ProtectionDomain;

public abstract class Context<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends AddressedReference<PATH,ID,I,A,R>,F extends Fact<?,F,?>> extends ProtectionDomain {

    protected final F parent;
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
        return (Personality)this.getPermissions();
    }
    @SuppressWarnings("unchecked")
    public Factory<PATH,ID,I,A,R,F> getFactory() {
        return (Factory<PATH,X,ID,I,C,R>) this.getClassLoader();
    }

    public abstract F getAuthority();

}
