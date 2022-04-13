package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Fabrication<F extends Fabrication<F,C,E,X,V,IM>,C extends Concept<C,X,IM>,E extends Effect<F,C,E,X,V,IM>,X extends Context.Platform<X>,V extends Volume<C,V>,IM extends Immortal<F,C,E,X,V,IM>> extends Industry<F,C,E, Identity.SuperEgo<X>,X,V,IM> {

    public Fabrication(Progenitor progenitor, LinkedBlockingDeque<E> operationalDeque, Map<Class<?>, List<Predictor<F, ?, C, E, Identity.SuperEgo<X>,X,V,IM,?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(F o) {
        return 0;
    }
}
