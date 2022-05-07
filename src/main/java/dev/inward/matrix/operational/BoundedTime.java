package dev.inward.matrix.operational;

import dev.inward.matrix.meta.time.Instant;

public abstract class BoundedTime implements Options.Bounded<Instant, BoundedTime> {


    ;
    private final String label;
    private final String description;
    private final Instant defaultValue;
    private final Instant maximumValue;

    BoundedTime(String label, String description, Instant defaultValue, Instant maximumValue) {
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
    public Instant getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public Instant maximumValue() {
        return this.maximumValue;
    }
}