package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Hospitality extends Industry<Hospitality,Persona,Psyche, Identity.Ego<Context.Service>, Context.Service,Skeleton,Spirit> {


    public Hospitality(Diplomat diplomat, LinkedBlockingDeque<Psyche> operationalDeque, Map<Class<?>, List<Predictor<Hospitality, ?, Persona, Psyche, Identity.Ego<Context.Service>, Context.Service, Skeleton, Spirit, ?, ?, ?>>> predictorMap) {
        super(diplomat, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(Hospitality o) {
        return 0;
    }

}
