package dev.inward.crud.operational;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.datum.time.InstantDatum;

public abstract class MaxValueTime implements Specification.MaxValue<InstantDatum, MaxValueTime> {


    ;
    private final String label;
    private final String description;
    private final InstantDatum defaultValue;
    private final InstantDatum maximumValue;

    MaxValueTime(String label, String description, InstantDatum defaultValue, InstantDatum maximumValue) {
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