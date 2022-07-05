package dev.inward.matrix.operational;

public enum BoundedLong implements Specification.Bounded<Long, BoundedLong> {


    ;
    private final String label;
    private final String description;
    private final Long defaultValue;
    private final Long maximumValue;

    BoundedLong(String label, String description, Long defaultValue, Long maximumValue) {
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