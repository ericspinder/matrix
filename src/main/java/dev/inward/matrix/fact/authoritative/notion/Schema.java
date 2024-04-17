package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.authority.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.yard.Tree;

import java.util.Map;

public class Schema<N extends Notion<N,I,X,?,?,?>,I extends Identity<I,X>,X extends Context<X>> extends Specification<N,I,X> {

    protected Tree[] trees;

    public Schema(final String datumClassName, final String i18n, final String description, final String fieldName, final String asmTransformerClassName, final String[] inductionClassNames, final Map<Criterion<N>, Zone[]> criteriaForZones, final Map<String, DefaultOption<?,?>> optionMap, Map<Indicia, ServerRecord[]> indiciaServerMap, Map<Standard<?>,Zone[]> standardsMap, Tree[] trees) {
        super(datumClassName,i18n,description,fieldName,asmTransformerClassName,inductionClassNames,criteriaForZones,optionMap, indiciaServerMap, standardsMap);
    }

    public Tree[] getPersonas() {
        return trees;
    }
}
