package dev.inward.matrix.fact.operational;

import dev.inward.matrix.fact.Specification;

public enum BooleanDefaultOption implements Specification.DefaultOption<Boolean, BooleanDefaultOption> {

    ConnectionContainer_Check_ResultSet("dev.inward.source.connectionMain.checkResultSet", "Order a check of all ResultSets before closing when cleanupAfterGC() had not been called, until the connection had been closed", true),
    Logging("dev.inward.source.connection.notion.jdbcProxy.aggregation.UseLogging", "Use ProxyV1 aggregation", false),
    LogNonExecuteProxyMembers("dev.inward.source.connection.notion.jdbcProxy.aggregation.LogNonExecuteProxyMembers", "Use a proxy wrapper for even non-execute proxy member classes, when aggregation is turned on", false),
    EqualsByUUID("dev.inward.source.wrapper.equalsByUUID", "Allow the wrapper Id to override the equals", false),
    False("dev.inward.source.false","false by default", false),
    True("dev.inward.source.true","true by default", true);
    private final String label;
    private final String i18n;
    private final String description;
    private final Boolean defaultValue;


    BooleanDefaultOption(String i18n, String description, Boolean defaultValue) {
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
    public Boolean getDefaultValue() {
        return this.defaultValue;
    }

    public static @interface BooleanDefault {
        BooleanDefaultOption booleanDefault() default False;
    }
}
