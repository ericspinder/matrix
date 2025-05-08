/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory.bureau;

import dev.inward.matrix.control.memory.MemoryView;

import java.util.HashMap;
import java.util.Map;

public abstract class BureauView<BC extends Bureau<BC,BV,BM>,BV extends BureauView<BC,BV,BM>,BM extends BureauModel<BC,BV,BM>> extends MemoryView<BC,BV,BM> {

    protected final Map<String,Object> attributes = new HashMap<>();

    public BureauView(String name, BC bureau) {
        super(name,bureau);
    }
}
