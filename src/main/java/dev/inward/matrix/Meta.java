package dev.inward.matrix;

import dev.inward.matrix.fact.Specification;

public class Meta<M extends Meta<M>> implements Meta_I<M> {

    protected final String label;
    protected final String description;

    public Meta(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public static class Default<DEFAULT extends Comparable<DEFAULT>> extends Meta<Default<DEFAULT>> {
        protected final Specification.DefaultOption option;
        public Default(Specification.DefaultOption option) {
            super(option.getDescription());
            this.option = option;
        }

    }

    @Override
    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(M that) {
        int isZero = this.label.compareTo(that.getLabel());
        if (isZero == 0) {
            isZero = this.description.compareTo(that.description);
        }
        return isZero;
    }
}
