package com.notionds.dataSupplier.operational;

import com.notionds.dataSupplier.*;
import com.notionds.dataSupplier.container.Phase;
import com.notionds.dataSupplier.library.RemoteServer;
import com.notionds.dataSupplier.meta.Meta_I;
import com.notionds.dataSupplier.rubric.Complication;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public abstract class Operational<DATUM extends Comparable<DATUM> & Serializable,O extends Operational<DATUM,O>> implements Comparable<O>, Serializable {

    public static final Local LOCAL_OPTIONS_INSTANCE = new Local();

    public interface Option<DATUM extends Comparable<DATUM> & Serializable,M extends Option<DATUM,M>> extends Meta_I<DATUM,M> {
        DATUM getDefaultValue();
    }
    private final Instant createInstant = Instant.now();
    protected StampedLock gate = new StampedLock();
    protected final Map<String, String> stringOptions = new HashMap<>();
    protected final Map<String, Integer> integerOptions = new HashMap<>();
    protected final Map<String, Duration> durationOptions = new HashMap<>();
    protected final Map<String, Boolean> booleanOptions = new HashMap<>();
    protected final Map<String, ComplicationOption> complicationsOptions = new HashMap<>();

    public static final class Local<DATUM extends Comparable<DATUM> & Serializable> extends Operational<DATUM, Local<DATUM>> {
        public Local() {
            super();
        }
    }
    public Operational() {
        this(Arrays.stream(Operational.class.getClass().getTypeParameters()).findFirst().get().getTypeName());
    }

    public Operational(final String name) {
            this.setDefaultValues(DurationOption.values());
            this.setDefaultValues(BooleanOption.values());
            this.setDefaultValues(IntegerOption.values());
//            this.setDefaultValues(TaskOption.values());
    }

    public Integer getInteger(String key, RemoteServer remoteServer) {
        if (this.integerOptions.containsKey(key)) {
            return this.integerOptions.get(key);
        }
        else if (remoteServer != null) {
            if (remoteServer.getContainer().getSituation().getPhase().equals(Phase.Lucid)) {
                remoteServer.getContainer()
            }
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass());
    }
    public String getString(String key, RemoteServer remoteServer) {
        if (this.stringOptions.containsKey(key)) {
            return this.stringOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass());
    }
    public Duration getDuration(String key, RemoteServer remoteServer) {
        if (this.durationOptions.containsKey(key)) {
            return this.durationOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass());
    }
    public Boolean getBoolean(String key, RemoteServer remoteServer) {
        if (this.booleanOptions.containsKey(key)) {
            return this.booleanOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissMatchedOptionKey, this.getClass());
    }
    public ComplicationOption getComplicationOption(String key, RemoteServer remoteServer) {
        if (this.complicationsOptions.containsKey(key)) {
            return this.complicationsOptions.get(key);

        }
        throw new NotionStartupException(NotionStartupException.Type.MissMatchedOptionKey, this.getClass());
    }
    public final <D> void setDefaultValues(Option<D,?>[] optionsLoad) {
        if (optionsLoad == null) return;
        long stamp = gate.writeLock();
        try {
            for (Option<D,?> option: optionsLoad) {
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
                else if (option.getDefaultValue() instanceof Complication) {
                    this.complicationsOptions.put(option.getI18n(),(Complication) option.getDefaultValue());
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
