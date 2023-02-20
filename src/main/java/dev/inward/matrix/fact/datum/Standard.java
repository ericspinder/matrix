package dev.inward.matrix.fact.datum;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Criterion;

public class Standard<S extends Standard<S>> implements Meta_I<S> {

    protected final Variant variant;
    protected final String className;
    protected final String label;
    protected final String description;
    protected final String transformerClassName;
    protected final String[] inductionClassNames;
    protected final Criterion[] criteria;

    public Standard(final Variant variant, final String className, final String label, final String description, final String transformerClassName, final String[] inductionClassNames, Criterion[] criteria) {
        this.variant = variant;
        this.className = className;
        this.description = description;
        this.label = label;
        this.transformerClassName = transformerClassName;
        this.inductionClassNames = inductionClassNames;
        this.criteria = criteria;
    }

    public Variant getVariant() {
        return variant;
    }

    public String getClassName() {
        return className;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getTransformerClassName() {
        return transformerClassName;
    }

    public String[] getInductionClassNames() {
        return inductionClassNames;
    }

    public Criterion[] getCriteria() {
        return criteria;
    }
}