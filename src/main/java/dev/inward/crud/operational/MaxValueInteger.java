/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud.operational;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

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