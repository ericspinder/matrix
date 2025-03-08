/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Director;
import dev.inward.matrix.MatrixItem;
import dev.inward.matrix.MatrixKey;
import dev.inward.matrix.route.Road;

public abstract class ComplicationCriterion<PATH extends Comparable<PATH>,K extends MatrixKey<PATH,K,I>,I extends MatrixItem<PATH,K,I>> extends Criterion<PATH,K,I> {
    public ComplicationCriterion(String label, String description, String i18n) {
        super(label, description, i18n);
    }

    public final Road getRoad(K matrixKey, Director director) {
        if (getOverrideRoad() == null) {
            return director.getDefaultRoad();
        }
        else {
            return director.getRoad(matrixKey, getOverrideRoad());
        }
    }
    protected Road getOverrideRoad() {
        return null;
    }

}
