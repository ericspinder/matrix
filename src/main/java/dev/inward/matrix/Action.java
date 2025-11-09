/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.Marked;
import dev.inward.matrix.predictable.Complication;

import java.time.Instant;
import java.util.UUID;

public class Action<TARGET> implements Marked {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createInstant = Instant.now();
    protected final Complication

    public enum ActionType implements Meta_I {
        Create("Create","Item creation", 1),
        Update("Update","Item updating", 2),
        Read("Read","Item reading", 3),
        Delete("Delete","Item deletion", 4),;

        private final String label;
        private final String description;
        private final int order;

        ActionType(String label,String description,int order) {
            this.label = label;
            this.description = description;
            this.order = order;
        }
        @Override
        public String getLabel() {
            return this.label;
        }

        @Override
        public String getDescription() {
            return this.description;
        }

        public int getOrder() {
            return this.order;
        }
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Instant getCreateInstant() {
        return createInstant;
    }

    protected final ActionType actionType;

    public Action(ActionType actionType) {
        this.actionType = actionType;
    }



    public ActionType getRestraintType() {
        return actionType;
    }
}
