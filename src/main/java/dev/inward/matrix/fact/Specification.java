package dev.inward.matrix.fact;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.matter.Indicia;
import crud.rubric.Roller;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.engine.Zone;

import java.util.*;

public class Specification<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>> extends Standard<F> {

    protected final Map<String, Option<?,?>> options;
    protected final Map<Indicia, Server[]> indiciaServerMap;
    protected final Map<Standard<?>, Zone[]> standardsMap;

    public Specification(final String datumClassName, final String i18n, final String description, final String fieldName, final String asmTransformerClassName, final String[] inductionClassNames, final Map<Criterion<F>, Zone[]> criteriaForZones, final Map<String,Option<?,?>> optionMap, Map<Indicia,Server[]> indiciaServerMap, Map<Standard<?>,Zone[]> standardsMap) {
        super(datumClassName,i18n,description,fieldName,asmTransformerClassName,inductionClassNames,criteriaForZones);
        this.options = optionMap;
        this.indiciaServerMap = indiciaServerMap;
        this.standardsMap = standardsMap;
    }

    public static void setDefaultValues(Option<?,?>[] optionsLoad,Map<String,Option<?,?>> options) throws Roller {
        if (optionsLoad == null) return;
        for (Option<?,?> option: optionsLoad) {
            options.put(option.getI18n(), option);
        }
    }

    public Map<Indicia, Server[]> getIndiciaServerMap() {
        return indiciaServerMap;
    }

    public List<Standard<?>> getStandards(Zone zone) {
        List<Standard<?>> standardsList = new ArrayList<>();
        for(Map.Entry<Standard<?>,Zone[]> entry: standardsMap.entrySet()) {
            for (Zone zoneTest: entry.getValue()) {
                if(zoneTest.equals(zone)) {
                    standardsList.add(entry.getKey());
                    break;
                }
            }
        }
        return standardsList;
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
