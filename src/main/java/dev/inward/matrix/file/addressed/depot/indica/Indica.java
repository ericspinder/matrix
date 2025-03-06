/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.indica;

import dev.inward.matrix.file.addressed.depot.Depot;

public class Indica extends Depot<IndiciaKey,Indica, IndicaReference, IndicaAttributes,IndicaResource,IndicaModel> {

    private final String complicationClassName;
    private final String complicationCriterionClassName;
    private final String policyClassName;
    private final String policyCriterionClassName;
    private final int seriesMaxSize;
    public Indica(IndiciaKey identity, String complicationClassName, String complicationCriterionClassName, String policyClassName, String policyCriterionClassName, int seriesMaxSize) {
        super(identity);
        this.complicationClassName = complicationClassName;
        this.complicationCriterionClassName = complicationCriterionClassName;
        this.policyClassName = policyClassName;
        this.policyCriterionClassName = policyCriterionClassName;
        this.seriesMaxSize = seriesMaxSize;
    }

    public String getComplicationClassName() {
        return complicationClassName;
    }

    public String getPolicyCriterionClassName() {
        return policyCriterionClassName;
    }

    public String getPolicyClassName() {
        return policyClassName;
    }

    public String getComplicationCriterionClassName() {
        return complicationCriterionClassName;
    }

    public int getSeriesMaxSize() {
        return seriesMaxSize;
    }

    @Override
    public String toString() {
        return "Indica{" + "complicationClassName='" + complicationClassName + '\'' +
                ", complicationCriterionClassName='" + complicationCriterionClassName + '\'' +
                ", policyClassName='" + policyClassName + '\'' +
                ", policyCriterionClassName='" + policyCriterionClassName + '\'' +
                ", seriesMaxSize=" + seriesMaxSize + '\'' +
                ", info=" + key +
                '}';
    }
}
