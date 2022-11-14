package dev.inward.matrix.fact.notion;

import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.personality.Persona;

import java.util.Map;

public class Schema<N extends Notion<N,I,X,?,?,?>,I extends Identity<I,X>,X extends Context<X>> extends Specification<N,I,X> {

    protected Persona[] personas;

    public Schema(final String datumClassName, final String i18n, final String description, final String fieldName, final String asmTransformerClassName, final String[] inductionClassNames, final Map<Criterion<N>, Zone[]> criteriaForZones, final Map<String,Option<?,?>> optionMap, Map<Indicia,Server[]> indiciaServerMap, Map<Standard<?>,Zone[]> standardsMap, Persona[] personas) {
        super(datumClassName,i18n,description,fieldName,asmTransformerClassName,inductionClassNames,criteriaForZones,optionMap, indiciaServerMap, standardsMap);
    }

    public Persona[] getPersonas() {
        return personas;
    }
}
