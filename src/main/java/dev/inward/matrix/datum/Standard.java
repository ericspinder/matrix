package dev.inward.matrix.datum;

import dev.inward.matrix.engine.Criterion;
import dev.inward.matrix.engine.Zone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Standard<DATUM> implements Comparable<Standard<DATUM>> {

    protected final String datumClassName;
    protected final String i18n;
    protected final String description;
    protected final String fieldName;
    protected final String transformerClassName;
    protected final String[] inductionClassNames;
    protected final Map<Criterion<DATUM>, Zone[]> criteriaForZones;

    public Standard(final String datumClassName, final String i18n, final String description, final String fieldName, final String transformerClassName, final String[] inductionClassNames, final Map<Criterion<DATUM>, Zone[]> criteriaForZones) {
        this.datumClassName = datumClassName;
        this.i18n = i18n;
        this.description = description;
        this.fieldName = fieldName;
        this.transformerClassName = transformerClassName;
        this.inductionClassNames = inductionClassNames;
        this.criteriaForZones = criteriaForZones;
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

    public String getTransformerClassName() {
        return transformerClassName;
    }

    public String[] getInductionClassNames() {
        return inductionClassNames;
    }

    public List<Criterion<DATUM>> getCriteria(Zone activeZone) {
        List<Criterion<DATUM>> criteria = new ArrayList<>();
        for(Map.Entry<Criterion<DATUM>,Zone[]> criterionEntry: this.criteriaForZones.entrySet()) {
            for (Zone zone: criterionEntry.getValue()) {
                if (zone.equals(activeZone)){
                    criteria.add(criterionEntry.getKey());
                    break;
                }
            }
        }
        return criteria;
    }
    public Map<Criterion<DATUM>,Zone[]> getCriteriaForZones() {
        return this.criteriaForZones;
    }

    @Override
    public int compareTo(Standard<DATUM> that) {
        return this.datumClassName.compareTo(that.datumClassName);
    }
}
