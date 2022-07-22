package dev.inward.matrix.operational;

import dev.inward.matrix.advisor.NotionStartupException;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.matter.Topic;
import dev.inward.matrix.meta.Meta_I;
import dev.inward.matrix.meta.Standard;
import dev.inward.matrix.rubric.Roller;
import dev.inward.matrix.rubric.Zone;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Specification<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>> {
    protected final Map<String, Option<?,?>> options = new HashMap<>();
    protected final Map<Standard<?,F,I,X>,Zone[]> standardZones;
    
    public Specification(final Map<Standard<?, F, I, X>,Zone[]> standardZones) {
        try {
            this.setDefaultValues(DurationOption.values());
            this.setDefaultValues(BooleanOption.values());
            this.setDefaultValues(IntegerOption.values());
        }
        catch (Roller roller) {
            throw new RuntimeException(roller);
        }
        this.standardZones = standardZones;
    }

    public final Map<Standard<?, F, I, X>,Zone[]> getStandardZones() {
        return this.standardZones;
    }

    public Option<Integer,?> getInteger(String key) {
        if (this.options.containsKey(key)) {
            try {
                return (Option<Integer,?>) this.options.get(key);
            }
            catch (ClassCastException cce) {
                throw new NotionStartupException(NotionStartupException.Type.ClassCastException, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,cce);
            }
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,null);
    }
    public Option<String,?> getString(String key) {
        if (this.options.containsKey(key)) {
            try {
                return (Option<String,?>) this.options.get(key);
            }
            catch (ClassCastException cce) {
                throw new NotionStartupException(NotionStartupException.Type.ClassCastException, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,cce);
            }
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,null);
    }
    public Option<Duration,?> getDuration(String key) throws Roller {
        if (this.options.containsKey(key)) {
            try {
                return (Option<Duration,?>) this.options.get(key);
            }
            catch (ClassCastException cce) {
                throw new NotionStartupException(NotionStartupException.Type.ClassCastException, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,cce);
            }
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,null);
    }
    public Option<Boolean,?> getBoolean(String key) throws Roller {
        if (this.options.containsKey(key)) {
            try {
                return (Option<Boolean,?>) this.options.get(key);
            }
            catch (ClassCastException cce) {
                throw new NotionStartupException(NotionStartupException.Type.ClassCastException, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,cce);
            }
        }
        throw new NotionStartupException(NotionStartupException.Type.MissingDefaultValue, StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,null);
    }
    public Map<String,Standard<?,F,I,X>> getStandards() {
        return this.standards;
    }

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

    public interface Option<OPTION,M extends Option<OPTION,M>> extends Meta_I<OPTION,M> {
        OPTION getDefaultValue();
    }
    public interface Bounded<OPTION,M extends Bounded<OPTION,M>> extends Option<OPTION,M> {
        OPTION maximumValue();
    }
    public interface Range<OPTION,M extends Range<OPTION,M>> extends Option<OPTION,M> {
        OPTION minimumValue();
    }
    public interface Choice<OPTION,M extends Choice<OPTION,M>> extends Option<OPTION,M> {
        OPTION[] choices();
    }
    public interface SuggestedChoice<OPTION,M extends SuggestedChoice<OPTION,M>> extends Option<OPTION,M> {
        M[] choices();
    }
    public interface SystemProperty<OPTION,M extends SystemProperty<OPTION,M>> extends Option<OPTION,M> {
        String systemPropKey();
    }

}
