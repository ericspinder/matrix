package dev.inward.matrix.datum.fact.persona;

import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Hospitality extends Industry<Hospitality,Persona,Psyche, Identity.Ego<Context.Service>, Context.Service,Skeleton,Spirit> {


    public Hospitality(Progenitor progenitor, LinkedBlockingDeque<Psyche> operationalDeque, Map<Class<?>, List<Predictor<Hospitality, ?, Persona, Psyche, Identity.Ego<Context.Service>, Context.Service, Skeleton, Spirit, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(Hospitality o) {
        return 0;
    }

}
