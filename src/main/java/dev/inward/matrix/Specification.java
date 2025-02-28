package dev.inward.matrix;

import dev.inward.matrix.code.Code;
import dev.inward.matrix.code.Path_ofCode;
import dev.inward.matrix.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.dns.resourceRecord.Zone;
import dev.inward.matrix.log.Indicia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Specification extends Code<Path_ofCode,Specification,> {

    protected final Map<String, DefaultOption<?,?>> options;
    protected final Map<Indicia.Focus, ServerRecord[]> focusServerMap;


    protected final Standard[] standards;

    public Specification(final Identity identity, final String description, Standard[] standards) {
        super(identity);
        this.options = optionMap;
        this.focusServerMap = focusServerMap;
        this.standards = standards;
    }


    public Map<Indicia.Focus, ServerRecord[]> getIndiciaServerMap() {
        return focusServerMap;
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
    public <MAT extends Matter<MAT,I,ID,VERSION,X>> ServerRecord[] getServer(MAT matter) {
        for (Map.Entry<Indicia, ServerRecord[]> indiciaEntry: indiciaServerMap.entrySet()) {
            Indicia indiciaKey = indiciaEntry.getKey();
            int isZero = indiciaKey.getInternetClass().compareTo(matter.getIndica().getInternetClass());
            if (isZero == 0) {
                return indiciaEntry.getValue();
            }
        }
        return this.askForMatch(matter);

    }
    public <MAT extends Matter<MAT,I,ID,X>> ServerRecord[] askForMatch(MAT matter) {

    }

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
