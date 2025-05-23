/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

public class AgentReference extends PrivilegeReference<Agent,AgentKey,AgentView,AgentModel,AgentReference,AgentLibrarian> {

    public AgentReference(Agent referent, AgentLibrarian librarian) {
        super(referent, librarian);
    }
}
