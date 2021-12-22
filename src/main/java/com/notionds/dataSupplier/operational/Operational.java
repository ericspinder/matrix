package com.notionds.dataSupplier.operational;

import com.notionds.dataSupplier.*;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.task.Result;
import com.notionds.dataSupplier.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Operational<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,?,?,?,?>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>> implements Comparable<O>, Serializable {

    private static final Logger logger = LogManager.getLogger(Operational.class);
    public static final Default DEFAULT_OPTIONS_INSTANCE = new Default();

    public interface Option<V> {
        String getI18n();
        V getDefaultValue();
        String getDescription();
    }
    private final Instant createInstant = Instant.now();
    protected StampedLock gate = new StampedLock();
    protected final Map<String, String> stringOptions = new HashMap<>();
    protected final Map<String, Integer> integerOptions = new HashMap<>();
    protected final Map<String, Duration> durationOptions = new HashMap<>();
    protected final Map<String, Boolean> booleanOptions = new HashMap<>();
    protected final Map<String, Wrap<Task>> taskOptions = new HashMap<>();

    public static final class Default<N, W extends Datum<N,?,T>,T extends Container<N,?,W>> extends Operational<N,W,T> {
        public Default() {
            super();
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
    public Operational() {
        this(Arrays.stream(Operational.class.getClass().getTypeParameters()).findFirst().get().getTypeName());
    }

    public Operational(final String name) {
            this.setDefaultValues(DurationOption.values());
    }

    public Integer getInteger(String key) {
        if (this.integerOptions.containsKey(key)) {
            return this.integerOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass());
    }
    public String getString(String key) {
        if (this.stringOptions.containsKey(key)) {
            return this.stringOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass());
    }
    public Duration getDuration(String key) {
        if (this.durationOptions.containsKey(key)) {
            return (Duration) this.durationOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass());
    }
    public Boolean getBoolean(String key) {
        if (this.booleanOptions.containsKey(key)) {
            return this.booleanOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissMatchedOptionKey, this.getClass());
    }
    public Task getTask(String key, Supplier<Result<?,?,?,?>> supplier, Consumer<Exception> consumer) {
        if (this.taskOptions.containsKey(key)) {
            Wrap<Task> taskWrap = this.taskOptions.get(key);
            taskWrap.g
        }
        throw new NotionStartupException(NotionStartupException.Type.MissMatchedOptionKey, this.getClass());
    }
    public final <D> void setDefaultValues(Option<D>[] optionsLoad) {
        logger.info("loading default values");
        if (optionsLoad == null) return;
        long stamp = gate.writeLock();
        try {
            for (Option<D> option: optionsLoad) {
                if (option.getDefaultValue() instanceof String) {
                    this.stringOptions.put(option.getI18n(), (String) option.getDefaultValue());
                }
                else if (option.getDefaultValue() instanceof Integer) {
                    this.integerOptions.put(option.getI18n(), (Integer) option.getDefaultValue());
                }
                else if (option.getDefaultValue() instanceof Boolean) {
                    this.booleanOptions.put(option.getI18n(), (Boolean) option.getDefaultValue());
                }
                else if (option.getDefaultValue() instanceof Duration) {
                    this.durationOptions.put(option.getI18n(), (Duration) option.getDefaultValue());
                }
                else {
                    throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass());
                }
            }
        }
        finally {
            gate.unlockWrite(stamp);
        }
    }
    public final void put(String key, String stringValue) {
        this.stringOptions.put(key, stringValue);
    }
    public final void put(String key, Integer integerValue) {
        this.integerOptions.put(key, integerValue);
    }
    public final void put(String key, Boolean booleanValue) {
        this.booleanOptions.put(key, booleanValue);
    }
    public final void put(String key, Duration durationValue) {
        this.durationOptions.put(key, durationValue);
    }

    @Override
    public int compareTo(O that) {
        return this.createInstant.compareTo(that.getCreateInstant());
    }
    public final Instant getCreateInstant() {
        return this.createInstant;
    }
}
