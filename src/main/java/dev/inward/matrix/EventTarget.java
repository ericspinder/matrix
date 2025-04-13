/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.predictable.Policy;

import java.nio.file.WatchEvent;

public class EventTarget<TARGET> implements WatchEvent.Kind<TARGET> {

    protected final Indica indica;
    protected final Class<TARGET> targetClass;
    protected final Class<Policy<Target>>

    @Override
    public String name() {
        return null;
    }

    @Override
    public Class<TARGET> type() {
        return null;
    }
}
