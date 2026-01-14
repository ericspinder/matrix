/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control;


import dev.inward.matrix.control.terrene.Terrene;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.UUID;

public interface Control<CO extends Control<CO,CV,CM>,CV extends ControlView<CO,CV,CM>,CM extends ControlModel<CO,CV,CM>> {

    int compareTo(Terrene that);

    UUID getUuid();
    String getName();
    CM getModel();

    Instant getCreateInstant();

    int compareTo(@NotNull CO that);
}