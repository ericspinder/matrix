/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.indica;

import dev.inward.matrix.concept.fact.addressed.depot.Depot;
import dev.inward.matrix.item.datum.Datum;
import dev.inward.matrix.item.datum.Seat;

import java.util.Arrays;

public class Indica extends Datum<Indica,IndicaView,IndicaModel> {

    protected final String locus;
    protected final Seat<Indica,IndicaView,IndicaModel> seat;
    private final String predictableClassName;
    private final String criterionClassName;
    private final String[] policyClassNames;

    public Indica(String locus, String complicationCriterionClassName, String[] policyClassNames,String predictableClassName) {
        this.locus = locus;
        this.criterionClassName = complicationCriterionClassName;
        this.policyClassNames = policyClassNames;
        this.predictableClassName = predictableClassName;
    }

    public String getPredictableClassName() {
        return predictableClassName;
    }

    public String getCriterionClassName() {
        return criterionClassName;
    }

    public String[] getPolicyClassNames() {
        return policyClassNames;
    }

}
