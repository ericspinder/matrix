package com.notionds.dataSupplier.options;

import com.notionds.dataSupplier.task.Task;

public enum TaskOption implements Options.Option<Wrap<Task>> {
    task("com.notionds..task.timeout", new Wrap<>(),"")
    ;
    private final String i18n;
    private final Wrap<Task> defaultValue;
    private final String description;
    TaskOption(String i18n, Wrap<Task> defaultValue, String description) {
        this.i18n = i18n;
        this.defaultValue = defaultValue;
        this.description = description;
    }
    @Override
    public String getI18n() {
        return i18n;
    }

    @Override
    public Wrap<Task> getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
