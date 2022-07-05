package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.util.Map;

/**
 *
 * @param <DATUM>
 * @param <F>
 * @param <I>
 * @param <X>
 */
public record Criteria<DATUM,F extends Fact<F,I,X,?>,I extends Identity<I, X>,X extends Context<X>> (
        Map<Criterion<DATUM,?,?,F,I,X,?>,Zone[]> criteriaForZones) {}
