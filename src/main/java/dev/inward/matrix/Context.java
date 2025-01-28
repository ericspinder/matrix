package dev.inward.matrix;

import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.http.Fact;
import dev.inward.matrix.info.Agent;
import dev.inward.matrix.info.House;
import dev.inward.matrix.personality.Personality;

import javax.annotation.Nullable;
import java.security.Principal;
import java.security.ProtectionDomain;

public abstract class Context<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representative<PATH,ID,I,A,R>,F extends Fact<?,F,?>> extends ProtectionDomain {

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
