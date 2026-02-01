/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control;

import java.time.Instant;
import java.util.UUID;

public interface Control<CO extends Control<CO,CV,CM>,CV extends ControlView<CO,CV,CM>,CM extends ControlModel<CO,CV,CM>> extends Comparable<CO> {

    UUID getUuid();
    String getName();

    Instant getCreateInstant();

    default int compareTo(CO that) {
        int isZero = this.getName().compareTo(that.getName());
        if (isZero == 0) return this.getUuid().compareTo(that.getUuid());
        return isZero;
    }
}