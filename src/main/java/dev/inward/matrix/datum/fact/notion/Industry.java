package dev.inward.matrix.datum.fact.notion;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class Industry<Y extends Industry<Y,N,S,I,X,O,P>,N extends Notion<N,I,X,P>,S extends Aspect<Y,N,S,I,X,O,P>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<N,O>,P extends Primogenitor<Y,N,S,I,X,O,P>> extends Factory<Y,N,S,I,X,O,P> {


    public Industry(Progenitor progenitor, LinkedBlockingDeque<S> operationalDeque, Map<Class<?>, List<Predictor<Y, ?, N, S, I, X, O, P, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }
}
