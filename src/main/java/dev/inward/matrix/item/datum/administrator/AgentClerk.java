/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.administrator;

import dev.inward.matrix.item.datum.specification.Specification;
import dev.inward.matrix.item.datum.standard.Standard;

public class AgentClerk extends AdministratorClerk<Agent,AgentView,AgentModel,AgentClerk> {

    public AgentClerk(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
