package dev.inward.matrix.fact;

import crud.rubric.Roller;
import dev.inward.matrix.Meta_I;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Specification extends Standard<F,I,ID,X> {

    protected final Map<String, DefaultOption<?,?>> options;
    protected final Map<Indicia.Focus, Server[]> focusServerMap;
    protected final Standard[] standards;

    public Specification(X context,final String className, final String label, final String description, final String transformerClassName, final String[] inductionClassNames, final Criterion[] criteria, final Map<String, DefaultOption<?,?>> optionMap, Map<Indicia.Focus,Server[]> focusServerMap, Standard<F,I,ID,X>[] standards) {
        super(context,className,label,description,transformerClassName,inductionClassNames,criteria);
        this.options = optionMap;
        this.focusServerMap = focusServerMap;
        this.standards = standards;
    }

    public static void setDefaultValues(DefaultOption<?,?>[] optionsLoad, Map<String, DefaultOption<?,?>> options) throws Roller {
        if (optionsLoad == null) return;
        for (DefaultOption<?,?> option: optionsLoad) {
            options.put(option.getI18n(), option);
        }
    }

    public Map<Indicia, Server[]> getIndiciaServerMap() {
        return indiciaServerMap;
    }

    public List<Standard<X,?>> getStandards(Zone zone) {
        List<Standard> standardsList = new ArrayList<>();
        for(Map.Entry<Standard,Zone[]> entry: standardContextsMap.entrySet()) {
            for (Zone zoneTest: entry.getValue()) {
                if(zoneTest.equals(zone)) {
                    standardsList.add(entry.getKey());
                    break;
                }
            }
        }
        return standardsList;
    }
    public <MAT extends Matter<MAT,I,ID,VERSION,X>> Server[] getServer(MAT matter) {
        for (Map.Entry<Indicia,Server[]> indiciaEntry: indiciaServerMap.entrySet()) {
            Indicia indiciaKey = indiciaEntry.getKey();
            int isZero = indiciaKey.getInternetClass().compareTo(matter.getIndica().getInternetClass());
            if (isZero == 0) {
                return indiciaEntry.getValue();
            }
        }
        return this.askForMatch(matter);

    }
    public abstract <MAT extends Matter<MAT,I,ID,VERSION,X>> Server[] askForMatch(MAT matter);

    public interface DefaultOption<OPTION,O extends DefaultOption<OPTION,O>> extends Meta_I<O> {
        OPTION getDefaultValue();
    }
    public interface MaxValue<OPTION,B extends MaxValue<OPTION,B>> extends Meta_I<B> {
        OPTION maximumValue();
    }
    public interface MinimumValue<OPTION,M extends MinimumValue<OPTION,M>> extends DefaultOption<OPTION,M> {
        OPTION minimumValue();
    }
    public interface Choice<OPTION,M extends Choice<OPTION,M>> extends DefaultOption<OPTION,M> {
        OPTION[] choices();
    }
    public interface SuggestedChoice<OPTION,S extends SuggestedChoice<OPTION,S>> extends DefaultOption<OPTION,S> {
        S[] choices();
    }
    public interface SystemProperty<OPTION,P extends SystemProperty<OPTION,P>> extends DefaultOption<OPTION,P> {
        String systemPropKey();
    }
    public Map<String, DefaultOption<?,?>> getOptions() {
        return this.options;
    }
}
