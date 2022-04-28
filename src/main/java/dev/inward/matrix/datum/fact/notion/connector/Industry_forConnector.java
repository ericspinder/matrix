package dev.inward.matrix.datum.fact.notion.connector;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;

public class Industry_forConnector extends Industry<Industry_forConnector,Connector,Aspect_ofConnector, Identity.Ego<Context.JVM>,Context.JVM, Omnibus_forConnector, Primogenitor_holdingConnector> {


    public Industry_forConnector(Aspect_ofConnector operational, Map<Class<?>, List<Predictor<Industry_forConnector, ?, Connector, Aspect_ofConnector, Identity.Ego<Context.JVM>, Context.JVM, Omnibus_forConnector, Primogenitor_holdingConnector, ?, ?, ?>>> predictors, Context.JVM[] context) {
        super(operational, predictors, context);
    }

    @Override
    public int compareTo(Industry_forConnector that) {
        ;
    }
}
