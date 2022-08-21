package dev.inward.matrix.standard.time;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.standard.Meta;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.standard.Standard;

import java.io.Serializable;

public abstract class TimeStandard<DATUM,IC extends Identity<IC,XC>,XC extends Context<XC>> extends Standard<DATUM,IC,XC> {

    protected Specification.Option[] timeOptions;

    public TimeStandard(String label, String description, String i18n) {
        super(label, description, i18n);
    }
}
