package dev.inward.matrix.fact;

import dev.inward.matrix.Meta_I;

public class Alert implements Meta_I {

    protected final String label;
    protected final String description;

    public Alert(String label, String description) {
        this.label = label;
        this.description = description;
    }
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
