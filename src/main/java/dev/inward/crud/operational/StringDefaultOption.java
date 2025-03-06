/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud.operational;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

public enum StringDefaultOption implements Specification.DefaultOption<String, StringDefaultOption> {
    Management_JMX("com.notionds.jmx.management", "JMX management mBean Implementation", "dev.inward.source.datum.fact.notion.concept.dataSupplier.jmx.NotionDsBean"),
    Aggregation_Method_REGEX("com.notionds.aggregation.method_regex", "The regex for the method or methods (how clever is your regex?) which need have an InvokeAccounting created", "^execute"),
    ;
    private final String label;
    private final String i18n;
    private final String description;
    private final String defaultValue;

    StringDefaultOption(String i18n, String description, String defaultValue) {
        this.label = name();
        this.i18n = i18n;
        this.description = description;
        this.defaultValue = defaultValue;
    }
    public String getLabel() {
        return this.label;
    }
    public String getLabel() {
        return i18n;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDefaultValue() {
        return this.defaultValue;
    }

    public @interface StringDefault {

    }
}
