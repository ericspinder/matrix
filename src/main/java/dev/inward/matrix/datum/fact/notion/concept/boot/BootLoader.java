package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Fabrication;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class BootLoader extends Fabrication<BootLoader,Boot,Init,Context.JVM,Structure,Root> {
    public BootLoader(LinkedBlockingDeque<Init> operationalDeque, Map<Class<?>, List<Predictor<BootLoader, ?, Boot, Init, Identity.SuperEgo<Context.JVM>, Context.JVM, Structure, Root, ?, ?, ?>>> predictorMap) {
        super(null, operationalDeque, predictorMap);
    }
}