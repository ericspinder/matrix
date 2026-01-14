/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.Concept;
import dev.inward.matrix.engine.Factory;
import dev.inward.matrix.concept.fact.Variant;
import dev.inward.matrix.concept.item.datum.administrator.Agent;

import java.security.ProtectionDomain;

public abstract class Context<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Concept<TARGET,V,M,C,X>,X extends Context<TARGET,V,M,C,X>> extends ProtectionDomain {

    public Context(Variant variant, C concept, Factory<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> factory, Agent[] agents) {
        super(variant,concept,factory,agents);
    }

    public Variant getVariant() {
        return (Variant) this.getCodeSource();
    }
    @SuppressWarnings("unchecked")
    public C getConcept() {
        return (C) this.getPermissions();
    }

    public Factory<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getFactory() {
        return (Factory<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>) this.getClassLoader();
    }
}
