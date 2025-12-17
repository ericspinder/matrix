/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.depot.indica;

import dev.inward.matrix.concept.fact.addressed.depot.Depot;
import dev.inward.matrix.predictable.Predictable;

import java.util.Arrays;

public class Indica<P extends Predictable> extends Depot<Indica<P>,IndicaKey<P>,IndicaView<P>,IndicaModel<P>, IndicaReference<P>, IndicaLibrarian<P>> {

    private final String predictableClassName;
    private final String criterionClassName;
    private final String[] policyClassNames;

    public Indica(IndicaKey<P> identity, String complicationCriterionClassName, String[] policyClassNames,String predictableClassName) {
        super(identity);
        this.criterionClassName = complicationCriterionClassName;
        this.policyClassNames = policyClassNames;
        this.predictableClassName = predictableClassName;
    }

    public String getPredictableClassName() {
        return predictableClassName;
    }

    public String[] getCriterionClassNames() {
        return criterionClassName;
    }

    public String[] getPolicyClassNames() {
        return policyClassNames;
    }

    @Override
    public String toString() {
        return "Indica{" + "policyClassName='" + Arrays.toString(policyClassNames) + '\'' +
                ", criterionClassName='" + criterionClassName + '\'' +
                ", indicaIdentity=" + key +
                '}';
    }
}
