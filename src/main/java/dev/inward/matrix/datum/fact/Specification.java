package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.operational.BooleanOption;
import dev.inward.matrix.datum.fact.operational.DurationOption;
import dev.inward.matrix.datum.fact.operational.IntegerOption;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.standard.Meta_I;
import dev.inward.matrix.standard.Standard;
import dev.inward.matrix.rubric.Roller;
import dev.inward.matrix.rubric.Zone;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Specification<C extends Fact<C,CI,CX,?,?,?>,CI extends Identity<CI,CX>,CX extends Context<CX>> {

    protected final Map<String, Option<?,?>> options = new HashMap<>();
    protected final Map<Standard<?>,Zone[]> standardZones;
    protected final Map<Indicia, Server> indiciaServerMap;
    
    public Specification(final Map<Standard<?>,Zone[]> standardZones,Map<Indicia,Server> indiciaServerMap) {
        try {
            this.setDefaultValues(DurationOption.values());
            this.setDefaultValues(BooleanOption.values());
            this.setDefaultValues(IntegerOption.values());
        }
        catch (Roller roller) {
            throw new RuntimeException(roller);
        }
        this.standardZones = standardZones;
        this.indiciaServerMap = indiciaServerMap;
    }

    public final Map<Standard<?>,Zone[]> getStandardZones() {
        return this.standardZones;
    }


    @SuppressWarnings("unchecked")
    public List<Standard<C>> getStandards(Zone zone) {
        List<Standard<C>> result = new ArrayList<>();
        for(Map.Entry<Standard<?>,Zone[]> standardEntry: standardZones.entrySet()) {
            for (Zone z: standardEntry.getValue()) {
                if (z.equals(zone)) {
                    result.add((Standard<C>)standardEntry.getKey());
                }
            }
        }
        return result;
    }

    public final <DATUM> void setDefaultValues(Option[] optionsLoad) throws Roller {
        if (optionsLoad == null) return;
        for (Option option: optionsLoad) {
            this.options.put(option.getI18n(), option);
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
