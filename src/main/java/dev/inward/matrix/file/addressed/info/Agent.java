/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.info;

import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.UserPrincipal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Agent extends Privilege<AgentLibrarian,AgentKey,Agent,AgentView,AgentModel,AgentReference, AgentSteward> implements UserPrincipal {

    protected final Map<House, AclEntry[]> houseRightsMap = new ConcurrentHashMap<>();


    public Agent(AgentKey key) {
        super(key);
    }
}
