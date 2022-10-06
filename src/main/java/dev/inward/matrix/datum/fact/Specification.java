package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.operational.BooleanOption;
import dev.inward.matrix.datum.fact.operational.DurationOption;
import dev.inward.matrix.datum.fact.operational.IntegerOption;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.matter.Indicia;
import crud.Meta_I;
import dev.inward.matrix.standard.Standard;
import dev.inward.matrix.rubric.Roller;
import dev.inward.matrix.rubric.Zone;

import java.util.*;

public class Specification<C extends Fact<C,CI,CX,?,?,?>,CI extends Identity<CI,CX>,CX extends Context<CX>> {

    protected final Map<String, Option<?,?>> options;
    protected final Map<Indicia, Server[]> indiciaServerMap;
    
    public Specification(final Map<String,Option<?,?>> optionMap, Map<Indicia,Server[]> indiciaServerMap) {
        this.options = optionMap;
        this.indiciaServerMap = indiciaServerMap;
    }
    public Specification(Map<Indicia,Server[]> indiciaServerMap) {
        this.options = new HashMap<>();
        try {
            setDefaultValues(DurationOption.values(),this.options);
            setDefaultValues(BooleanOption.values(),this.options);
            setDefaultValues(IntegerOption.values(),this.options);
        }
        catch (Roller roller) {
            throw new RuntimeException(roller);
        }
        this.indiciaServerMap = indiciaServerMap;
    }

    public static final void setDefaultValues(Option<?,?>[] optionsLoad,Map<String,Option<?,?>> options) throws Roller {
        if (optionsLoad == null) return;
        for (Option<?,?> option: optionsLoad) {
            options.put(option.getI18n(), option);
        }
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
    public Map<String, Option<?,?>> getOptions() {
        return this.options;
    }
}
