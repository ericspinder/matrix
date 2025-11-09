/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Concept;
import dev.inward.matrix.Model;
import dev.inward.matrix._WeakReference;
import dev.inward.matrix.View;
import dev.inward.matrix.file.addressed.log.Log;

import java.util.ArrayList;
import java.util.List;

public class Bout<TARGET> {

    protected final TARGET target;
    protected final List<? extends Log> completedMatters = new ArrayList<>();

    public Bout(TARGET target) {
        this.target = target;
    }

    public TARGET getDatum() {
        return target;
    }


    public List<? extends Log> getCompletedMatters() {
        return completedMatters;
    }
}
