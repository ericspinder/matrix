package dev.inward.matrix.operational;

public enum BoundedInteger implements Options.Bounded<Integer, BoundedInteger> {

    ;
    private final String label;
    private final String description;
    private final Integer defaultValue;
    private final Integer maximumValue;

    BoundedInteger(String label, String description, Integer defaultValue, Integer maximumValue) {
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