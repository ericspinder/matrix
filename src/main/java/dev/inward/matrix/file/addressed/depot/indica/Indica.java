/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.indica;

import dev.inward.matrix.file.addressed.depot.Depot;

public class Indica extends Depot<Indica,IndicaKey,IndicaView,IndicaModel, IndicaReference, IndicaLibrarian> {

    private final String criterionClassName;
    private final String policyClassName;
    public Indica(IndicaKey identity, String complicationCriterionClassName, String policyClassName) {
        super(identity);
        this.criterionClassName = complicationCriterionClassName;
        this.policyClassName = policyClassName;
    }

    public String getCriterionClassName() {
        return criterionClassName;
    }

    public String getPolicyClassName() {
        return policyClassName;
    }

    @Override
    public String toString() {
        return "Indica{" + "policyClassName='" + policyClassName + '\'' +
                ", criterionClassName='" + criterionClassName + '\'' +
                ", indicaIdentity=" + key +
                '}';
    }
}
