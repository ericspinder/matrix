package dev.inward.crud.operational;

import dev.inward.matrix.fact.Specification;

public enum MaxValueLong implements Specification.MaxValue<Long, MaxValueLong> {


    ;
    private final String label;
    private final String description;
    private final Long defaultValue;
    private final Long maximumValue;

    MaxValueLong(String label, String description, Long defaultValue, Long maximumValue) {
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
    public Long getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public Long maximumValue() {
        return this.maximumValue;
    }
}