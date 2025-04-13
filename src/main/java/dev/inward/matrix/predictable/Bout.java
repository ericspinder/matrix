/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Steward;
import dev.inward.matrix.Model;
import dev.inward.matrix.Reference;
import dev.inward.matrix.View;
import dev.inward.matrix.file.addressed.log.Matter;

import java.util.ArrayList;
import java.util.List;

public class Bout<DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,G>,G extends Steward<DATUM,V,M,R,G>> {

    protected final DATUM datum;
    protected final List<? extends Matter> completedMatters = new ArrayList<>();

    public Bout(DATUM datum) {
        this.datum = datum;
    }

    public DATUM getDatum() {
        return datum;
    }


    public List<? extends Matter> getCompletedMatters() {
        return completedMatters;
    }
}
