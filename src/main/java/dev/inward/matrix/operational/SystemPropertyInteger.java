package dev.inward.matrix.operational;

public enum SystemPropertyInteger implements Options.SystemProperty<Integer, SystemPropertyInteger> {
    DNS_TIME_TO_LIVE;
    private String label;
    private String description;
    private Integer defaultValue;
    private SystemPropertyInteger[] choices;
    private String systemPropKey;
    ;

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Integer getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public SystemPropertyInteger[] choices() {
        return SystemPropertyInteger.values();
    }

    @Override
    public String systemPropKey() {
        return this.systemPropKey;
    }

    public @interface SystemPropertyDefault {
        SystemPropertyInteger value();
    }
}
