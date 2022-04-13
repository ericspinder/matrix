package dev.inward.matrix.datum.fact.notion.concept.evaluate;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Bakery extends Fabrication<Bakery,Evaluate,Batch, Context.Service,Calc,Existent> {
    public Bakery(Progenitor progenitor, LinkedBlockingDeque<Batch> operationalDeque, Map<Class<?>, List<Predictor<Bakery, ?, Evaluate, Batch, Identity.SuperEgo<Context.Service>, Context.Service, Calc, Existent, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }
}
