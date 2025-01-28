package dev.inward.crud.operational;

import dev.inward.matrix.Specification;

public enum MaxValueInteger implements Specification.MaxValue<Integer, MaxValueInteger> {

    ;
    private final String label;
    private final String description;
    private final Integer defaultValue;
    private final Integer maximumValue;

    MaxValueInteger(String label, String description, Integer defaultValue, Integer maximumValue) {
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
    public Integer getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public Integer maximumValue() {
        return this.maximumValue;
    }
}