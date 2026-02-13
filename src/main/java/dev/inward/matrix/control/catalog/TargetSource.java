/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog;

import java.util.Map;

public abstract class TargetSource {

    public TargetSource(Map<String,Object> attributes) {

    }
    public abstract void load(Map<String,Object> attributes);
    public abstract boolean test();
}
