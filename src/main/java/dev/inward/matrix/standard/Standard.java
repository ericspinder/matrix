package dev.inward.matrix.standard;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Criteria;


public abstract class Standard<DATUM,I extends Identity<I,X>,X extends Context<X>> {

    protected final String datumClassName;
    protected final String i18n;
    protected final String description;
    protected final String fieldName;
    protected final Criteria<DATUM,?,I,X>[] criteria;

    public Standard(final String datumClassName, final String i18n, final String description, final String fieldName, final Criteria<DATUM,?,I,X>[] criteria) {
        this.datumClassName = datumClassName;
        this.i18n = i18n;
        this.description = description;
        this.fieldName = fieldName;
        this.criteria = criteria;
    }

    public String getDatumClassName() {
        return datumClassName;
    }

    public String getI18n() {
        return i18n;
    }

    public String getDescription() {
        return description;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Criteria<DATUM, ?, I, X>[] getCriteria() {
        return criteria;
    }
}
