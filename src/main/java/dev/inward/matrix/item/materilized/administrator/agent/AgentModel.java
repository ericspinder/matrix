/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.materilized.administrator.agent;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.item.materilized.administrator.MaterializedModel;

public class AgentModel extends MaterializedModel<Agent,AgentView,AgentModel,AgentClerk> {
    public AgentModel(Aspect[] labeledAspects) {
        super(Agent.class,labeledAspects);
    }
}
