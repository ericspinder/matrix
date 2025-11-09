/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.Bus;

public interface OmniBus extends Bus {

    /**
     *
     * @return False is not being held already. True if it was being held.
     */
    default boolean releaseForGarbageCollection() {
        if (isHeld()) {
            this.getAttributes().remove("held");
            return true;
        }
        else {
            return false;
        }
    }

    default boolean isHeld() {
        return this.getAttributes().get("held") != null;
    }
}
