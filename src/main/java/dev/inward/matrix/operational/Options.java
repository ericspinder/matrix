package dev.inward.matrix.operational;

import dev.inward.matrix.advisor.NotionStartupException;

import dev.inward.matrix.domain.RemoteServer;
import dev.inward.matrix.matter.Topic;
import dev.inward.matrix.meta.Meta_I;
import dev.inward.matrix.rubric.Roller;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Options {
    protected final Map<String, String> stringOptions = new HashMap<>();
    protected final Map<String, Integer> integerOptions = new HashMap<>();
    protected final Map<String, Duration> durationOptions = new HashMap<>();
    protected final Map<String, Boolean> booleanOptions = new HashMap<>();


    public Options() {
        try {
            this.setDefaultValues(DurationOption.values());
            this.setDefaultValues(BooleanOption.values());
            this.setDefaultValues(IntegerOption.values());
        }
        catch (Roller roller) {
            throw new RuntimeException(roller);
        }
    }

    public Integer getInteger(String key, RemoteServer remoteServer) throws Roller {
        if (this.integerOptions.containsKey(key)) {
            return this.integerOptions.get(key);
        }
        else if (remoteServer != null) {
//            if (remoteServer.getContainer().getSituation().getPhase().equals(Phase.Lucid)) {
//                remoteServer.getContainer()
//            }
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,new Exception("missing "));
    }
    public String getString(String key, RemoteServer remoteServer)  throws Roller{
        if (this.stringOptions.containsKey(key)) {
            return this.stringOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,new Exception("roller"));
    }
    public Duration getDuration(String key, RemoteServer remoteServer) throws Roller {
        if (this.durationOptions.containsKey(key)) {
            return this.durationOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,new Exception("roller"));
    }
    public Boolean getBoolean(String key, RemoteServer remoteServer) throws Roller {
        if (this.booleanOptions.containsKey(key)) {
            return this.booleanOptions.get(key);
        }
        throw new NotionStartupException(NotionStartupException.Type.MissMatchedOptionKey, this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,new Exception("roller"));
    }
//    public <D extends Datum> Complication<?,?,F,O,S,I,X,?,?,?>[] getComplications(Class<D> datumClass, Class<Criterion<?,?,F,O,S,I,X,?,?>> criterionClass) {
////        if (this.complicationsByCriterionForClass.containsKey(datumClass)) {
////            Map<Class<Criterion<?,?,F,O,S,I,X,?,?>>,Complication<?,?,F,O,S,I,X,?,?,?>[]> criterionMap = this.complicationsByCriterionForClass.get(datumClass);
////            return criterionMap.get(criterionClass);
////        }
//        return null;
//    }

    public final <DATUM> void setDefaultValues(Option[] optionsLoad) throws Roller {
        if (optionsLoad == null) return;
        for (Option option: optionsLoad) {
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
                throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,new Exception("roller"));
            }
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

    public interface Option<DATUM,M extends Option<DATUM,M>> extends Meta_I<DATUM,M> {
        DATUM getDefaultValue();
    }
    public interface Bounded<DATUM,M extends Bounded<DATUM,M>> extends Option<DATUM,M> {
        DATUM maximumValue();
    }
    public interface Range<DATUM,M extends Range<DATUM,M>> extends Option<DATUM,M> {
        DATUM minimumValue();
    }
    public interface Choice<DATUM,M extends Choice<DATUM,M>> extends Option<DATUM,M> {
        DATUM[] choices();
    }
    public interface SuggestedChoice<DATUM,M extends SuggestedChoice<DATUM,M>> extends Option<DATUM,M> {
        M[] choices();
    }
    public interface SystemProperty<DATUM,M extends SystemProperty<DATUM,M>> extends Option<DATUM,M> {
        String systemPropKey();
    }

}
