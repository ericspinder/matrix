/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.item.datum.administrator;

import dev.inward.matrix.Meta_I;

import java.nio.file.attribute.UserPrincipal;
import java.util.Map;

public class Agent extends Administrator<Agent,AgentView,AgentModel,AgentClerk> implements UserPrincipal {

    public enum Role implements Meta_I {

        
    }
    protected final Map<Persona,Role> personas = new HashMap<>();


    public Agent(
}
