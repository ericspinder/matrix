package dev.inward.matrix.operational;

public enum BooleanOption implements Specification.Option<Boolean,BooleanOption> {

    ConnectionContainer_Check_ResultSet("dev.inward.matrix.connectionMain.checkResultSet", "Order a check of all ResultSets before closing when cleanupAfterGC() had not been called, until the connection had been closed", true),
    Logging("dev.inward.matrix.connection.notion.jdbcProxy.aggregation.UseLogging", "Use ProxyV1 aggregation", false),
    LogNonExecuteProxyMembers("dev.inward.matrix.connection.notion.jdbcProxy.aggregation.LogNonExecuteProxyMembers", "Use a proxy wrapper for even non-execute proxy member classes, when aggregation is turned on", false),
    EqualsByUUID("dev.inward.matrix.wrapper.equalsByUUID", "Allow the wrapper Id to override the equals", false),
    False("dev.inward.matrix.false","false by default", false),
    True("dev.inward.matrix.true","true by default", true);
    private final String label;
    private final String i18n;
    private final String description;
    private final Boolean defaultValue;


    BooleanOption(String i18n, String description, Boolean defaultValue) {
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
    public Boolean getDefaultValue() {
        return this.defaultValue;
    }

    public static @interface BooleanDefault {
        BooleanOption booleanDefault() default False;
    }
}
