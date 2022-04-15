package com.notionds.jdbc;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Industry_forConnector extends Industry<Industry_forConnector,Connector,Aspect_ofConnector, Identity.Ego<Context.JVM>,Context.JVM,Omnibus_forConnector, Primogenitor_holdingConnector> {
    public Industry_forConnector(Progenitor progenitor, LinkedBlockingDeque<Aspect_ofConnector> operationalDeque, Map<Class<?>, List<Predictor<Industry_forConnector, ?, Connector, Aspect_ofConnector, Identity.Ego<Context.JVM>, Context.JVM, Omnibus_forConnector, Primogenitor_holdingConnector, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(Industry_forConnector that) {
        ;
    }
}
