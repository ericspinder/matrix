package dev.inward.matrix.standard;

import dev.inward.matrix.rubric.Zone;

import java.util.Map;

public abstract class Standard<DATUM> implements Comparable<Standard> {

    protected final String datumClassName;
    protected final String i18n;
    protected final String description;
    protected final String fieldName;
    protected final Map<String, Zone[]> inductionClassNameByZone;
    protected final Map<String, Zone[]> criteriaClassNamesByZone;

    public Standard(final String datumClassName, final String i18n, final String description, final String fieldName, final String inductionClassName, final Map<String, Zone[]> criteriaClassNamesByZone, final Zone[] zones) {
        this.datumClassName = datumClassName;
        this.i18n = i18n;
        this.description = description;
        this.fieldName = fieldName;
        this.inductionClassName = inductionClassName;
        this.criteriaClassNamesByZone = criteriaClassNamesByZone;
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
    public String[][] getCriteriaClassNamesByZone() {
        return this.criteriaClassNamesByZone;
    }
    public Zone[] getZones() {
        return this.zones;
    }
}
