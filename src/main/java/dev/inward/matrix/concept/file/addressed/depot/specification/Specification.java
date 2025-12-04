/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.file.addressed.depot.specification;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.concept.file.addressed.depot.Depot;
import dev.inward.matrix.concept.file.addressed.depot.indica.IndicaKey;
import dev.inward.matrix.concept.file.addressed.depot.standard.Standard;
import dev.inward.matrix.concept.file.addressed.dns.serverRecord.ServerRecord;

import java.util.Map;

public class Specification extends Depot<Specification,SpecificationKey,SpecificationView,SpecificationModel, SpecificationReference, SpecificationLibrarian> {

    protected final Map<String, DefaultOption<?,?>> options;
    protected final Map<IndicaKey, ServerRecord[]> focusServerMap;


    protected final Standard[] standards;

    public Specification(final SpecificationKey identity, final String description, Standard[] standards) {
        super(identity);
        this.standards = standards;
    }


    public Map<IndicaKey.Focus, ServerRecord[]> getIndiciaServerMap() {
        return focusServerMap;
    }

    public Standard[] getStandards() {
        return standards;
    }
    public <MAT extends Matter<MAT,I,ID,VERSION,X>> ServerRecord[] getServer(MAT matter) {
        for (Map.Entry<IndicaKey, ServerRecord[]> indiciaEntry: indiciaServerMap.entrySet()) {
            IndicaKey indicaKey = indiciaEntry.getKey();
            int isZero = indicaKey.getInternetClass().compareTo(matter.getIndica().getInternetClass());
            if (isZero == 0) {
                return indiciaEntry.getValue();
            }
        }
        return this.askForMatch(matter);

    }
    public <MAT extends Matter<MAT,I,ID,X>> ServerRecord[] askForMatch(MAT matter) {

    }

    public interface DefaultOption<OPTION,O extends DefaultOption<OPTION,O>> extends Meta_I<O> {
        OPTION getDefaultValue();
    }
    public interface MaxValue<OPTION,B extends MaxValue<OPTION,B>> extends Meta_I<B> {
        OPTION maximumValue();
    }
    public interface MinimumValue<OPTION,M extends MinimumValue<OPTION,M>> extends DefaultOption<OPTION,M> {
        OPTION minimumValue();
    }
    public interface Choice<OPTION,M extends Choice<OPTION,M>> extends DefaultOption<OPTION,M> {
        OPTION[] choices();
    }
    public interface SuggestedChoice<OPTION,S extends SuggestedChoice<OPTION,S>> extends DefaultOption<OPTION,S> {
        S[] choices();
    }
    public interface SystemProperty<OPTION,P extends SystemProperty<OPTION,P>> extends DefaultOption<OPTION,P> {
        String systemPropKey();
    }
    public Map<String, DefaultOption<?,?>> getOptions() {
        return this.options;
    }
}
