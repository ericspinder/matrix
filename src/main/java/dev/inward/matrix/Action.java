/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.Marked;

import java.time.Instant;
import java.util.UUID;

public class Action implements Marked {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createInstant = Instant.now();

    public enum ActionType implements Meta_I {
        Create("Create","Item creation"),
        Read("Read","Item reading"),
        Update("Update","Item updating"),
        Delete("Delete","Item deletion"),;

        private final String label;
        private final String description;

        ActionType(String label,String description) {
            this.label = label;
            this.description = description;
        }
        @Override
        public String getLabel() {
            return this.label;
        }

        @Override
        public String getDescription() {
            return this.description;
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
