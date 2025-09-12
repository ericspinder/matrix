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

public class Bout<DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends _WeakReference<DATUM,V,M,R,G>,G extends Concept<DATUM,V,M,R,G>> {

    protected final DATUM datum;
    protected final List<? extends Log> completedMatters = new ArrayList<>();

    public Bout(DATUM datum) {
        this.datum = datum;
    }

    public DATUM getDatum() {
        return datum;
    }


    public List<? extends Log> getCompletedMatters() {
        return completedMatters;
    }
}
