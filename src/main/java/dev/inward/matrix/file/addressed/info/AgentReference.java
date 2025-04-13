/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

public class AgentReference extends PrivilegeReference<AgentLibrarian,AgentKey,Agent,AgentView,AgentModel,AgentReference, AgentSteward> {
    public AgentReference(Agent addressed, AgentSteward resource) {
        super(addressed, resource);
    }
}
