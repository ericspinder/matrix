package dev.inward.matrix.operational;

public enum StringOption implements Options.Option<String,StringOption> {
    Management_JMX("com.notionds.jmx.management", "JMX management mBean Implementation", "dev.inward.matrix.datum.fact.notion.concept.dataSupplier.jmx.NotionDsBean"),
    Aggregation_Method_REGEX("com.notionds.aggregation.method_regex", "The regex for the method or methods (how clever is your regex?) which need have an InvokeAccounting created", "^execute"),
    ;
    private final String label;
    private final String i18n;
    private final String description;
    private final String defaultValue;

    StringOption(String i18n, String description, String defaultValue) {
        this.label = name();
        this.i18n = i18n;
        this.description = description;
        this.defaultValue = defaultValue;
    }
    public String getLabel() {
        return this.label;
    }
    public String getI18n() {
        return i18n;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDefaultValue() {
        return this.defaultValue;
    }

    public static @interface StringDefault {

    }
}
