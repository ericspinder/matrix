package com.notionds.dataSupplier.operational;

import com.notionds.dataSupplier.*;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.library.RemoteServer;
import com.notionds.dataSupplier.meta.Meta_I;
import com.notionds.dataSupplier.provider.Parent;
import com.notionds.dataSupplier.rubric.Complication;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public abstract class Operational<F extends Fact<F,O,I,X,B,A>,O extends Operational<F,O,I,X,B,A>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,I,X,B>,A extends Parent<F,O,I,X,A>> {

    public interface Option<DATUM extends Comparable<DATUM> & Serializable,M extends Option<DATUM,M>> extends Meta_I<DATUM,M> {
        DATUM getDefaultValue();
    }
    private final Instant createInstant = Instant.now();
    protected StampedLock gate = new StampedLock();
    protected final Map<String, String> stringOptions = new HashMap<>();
    protected final Map<String, Integer> integerOptions = new HashMap<>();
    protected final Map<String, Duration> durationOptions = new HashMap<>();
    protected final Map<String, Boolean> booleanOptions = new HashMap<>();
//    protected final Map<Class<Datum<?,?,?,F,O,S,I,X>>, Map<Class<Criterion<?,?,F,O,S,I,X,?,?>>,Complication<?,?,F,O,S,I,X,?,?,?>[]>> complicationsByCriterionForClass = new HashMap<>();

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
//            if (remoteServer.getContainer().getSituation().getPhase().equals(Phase.Lucid)) {
//                remoteServer.getContainer()
//            }
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
//    public <D extends Datum> Complication<?,?,F,O,S,I,X,?,?,?>[] getComplications(Class<D> datumClass, Class<Criterion<?,?,F,O,S,I,X,?,?>> criterionClass) {
////        if (this.complicationsByCriterionForClass.containsKey(datumClass)) {
////            Map<Class<Criterion<?,?,F,O,S,I,X,?,?>>,Complication<?,?,F,O,S,I,X,?,?,?>[]> criterionMap = this.complicationsByCriterionForClass.get(datumClass);
////            return criterionMap.get(criterionClass);
////        }
//        return null;
//    }

    public final <DATUM extends Comparable<DATUM> & Serializable> void setDefaultValues(Option<DATUM,?>[] optionsLoad) {
        if (optionsLoad == null) return;
        long stamp = gate.writeLock();
        try {
            for (Option<DATUM,?> option: optionsLoad) {
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
//                    this.complicationsByCriterionForClass.put(option.getI18n(),(Complication) option.getDefaultValue());
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

    public final Instant getCreateInstant() {
        return this.createInstant;
    }
}
