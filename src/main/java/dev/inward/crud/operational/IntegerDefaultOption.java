package dev.inward.crud.operational;

import dev.inward.matrix.fact.Specification;

public enum IntegerDefaultOption implements Specification.DefaultOption<Integer, IntegerDefaultOption> {
    Advice_Exception_Aggregator_Map_Max_Size("com.notionds.advice.exception.aggregatorMap.maxSize", "The number of ", 1000),
    Advice_Nominal_Aggregator_Map_Max_Size("com.notionds.advice.nominal.aggregatorMap.maxSize", "The number of ", 1000),
    //ConnectionAnalysis_Max_Exceptions("com.notionds.connectionAnalysis.maxExceptions", "The maximum number of noncritical sql Exceptions before a connection will terminate", 5),
    //ConnectionAnalysis_Max_Normal_Seconds("com.notionds.connectionAnalysis.maxNormalSeconds", "The maximum time of an operation before it's reported as abnormal", 10),
    Connection_Max_Wait_On_Create("com.notionds.connection.max_weight_on_create", "The maximum amount of time in milliseconds until a RuntimeException is thrown to end", 1000),
    Connection_Max_Queue_Size("com.notionds.connection.Max_Queue_Size", "Max Connection Queue size", 50),
    Connections_Min_Active("com.notionds.connection.min_queue_size", "", 10),
    DnsTimeout("com.notionds.dns.timeout", "Sets the default DNS timeout for the entire application", 30),
    Minimum_Replenishment("com.notionds.provider", "Smallest number of new Notions to make for a Pool", 1),
    Zero("dev.inward.source.zero","Default to Zero", 0),
    NegativeOne("dev.inward.source.negative_one","",-1),
    One("dev.inward.source.one","Exactly one is used by default",1),
    ;
    private final String label;
    private final String i18n;
    private final String description;
    private final Integer defaultValue;

    IntegerDefaultOption(String i18n, String description, Integer defaultValue) {
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
    public Integer getDefaultValue() {
        return this.defaultValue;
    }

    public @interface IntegerDefault {
        IntegerDefaultOption value() default Zero;
    }
}
