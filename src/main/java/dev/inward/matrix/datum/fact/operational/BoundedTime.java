package dev.inward.matrix.datum.fact.operational;

import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.standard.time.InstantDatum;

public abstract class BoundedTime implements Specification.Bounded<InstantDatum, BoundedTime> {


    ;
    private final String label;
    private final String description;
    private final InstantDatum defaultValue;
    private final InstantDatum maximumValue;

    BoundedTime(String label, String description, InstantDatum defaultValue, InstantDatum maximumValue) {
        this.label = label;
        this.description = description;
        this.defaultValue = defaultValue;
        this.maximumValue = maximumValue;
    }
    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public InstantDatum getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public InstantDatum maximumValue() {
        return this.maximumValue;
    }
}