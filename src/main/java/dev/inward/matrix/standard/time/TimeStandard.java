package dev.inward.matrix.standard.time;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.standard.Standard;

public abstract class TimeStandard<DATUM,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Standard<DATUM,IC,XC> {

    protected Specification.Option[] timeOptions;

    public TimeStandard(String label, String description, String i18n) {
        super(label, description, i18n);
    }
}
