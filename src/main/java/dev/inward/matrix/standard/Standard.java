package dev.inward.matrix.standard;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Zone;


public abstract class Standard<DATUM> {

    protected final String datumClassName;
    protected final String i18n;
    protected final String description;
    protected final String fieldName;
    protected final String inductionClassName;
    protected final String[] criteriaClassNames;
    protected final Zone[] zones;

    public Standard(final String datumClassName, final String i18n, final String description, final String fieldName,final String inductionClassName, final String[] criteriaClassNames, final Zone[] zones) {
        this.datumClassName = datumClassName;
        this.i18n = i18n;
        this.description = description;
        this.fieldName = fieldName;
        this.inductionClassName = inductionClassName;
        this.criteriaClassNames = criteriaClassNames;
        this.zones = zones;
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

    public String getInductionClassName() {
        return this.inductionClassName;
    }
    public String[] getCriteriaClassNames() {
        return this.criteriaClassNames;
    }
    public Zone[] getZones() {
        return this.zones;
    }
}
