package dev.inward.matrix.standard.time;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.rubric.Zone;
import dev.inward.matrix.standard.Standard;

public abstract class TimeStandard<DATUM> extends Standard<DATUM> {

    protected final Specification.Option[] timeOptions;

    public TimeStandard(final String datumClassName, final String i18n, final String description, final String fieldName,final String inductionClassName, final String[] criteriaClassNames, final Zone[] zones,final  Specification.Option[] timeOptions) {
        super(datumClassName,i18n,description,fieldName,inductionClassName,criteriaClassNames,zones);
        this.timeOptions = timeOptions;
    }
}
