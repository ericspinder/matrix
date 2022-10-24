package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.Standard;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.engine.Zone;

import java.util.Map;

public class Schema<N extends Notion<N,I,X,?>,I extends Identity<I,X>,X extends Context<X>> extends Specification<N,I,X> {

    public Schema(Map<String, Option<?, ?>> optionMap, Map<Indicia, Server[]> indiciaServerMap, Map<Standard<?>, Zone[]> standardsMap) {
        super(optionMap, indiciaServerMap, standardsMap);
    }

}
