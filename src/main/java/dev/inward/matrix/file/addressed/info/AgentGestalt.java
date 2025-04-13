/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.info;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class AgentGestalt extends PrivilegeGestalt<AgentKey, Agent,AgentReference, AgentView, AgentGestalt,AgentModel> {
    public AgentGestalt(Function<AgentReference, AgentReference> graveDigger, AgentModel model, Class<AgentView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
