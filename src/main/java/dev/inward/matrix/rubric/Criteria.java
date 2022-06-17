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
 * @param <D>
 * @param <V>
 * @param <F>
 * @param <I>
 * @param <X>
 * @param <P>
 * @param <N>
 * @param <NP>
 * @param <V>
 */
public record Criteria<DATUM, D extends Datum<DATUM,D, V,F,I,X,P>,V extends Envoy<DATUM,D, V,F,I, X, P>, F extends Fact<F, I, X, P>, I extends Identity<I, X>, X extends Context<X>, P extends Diplomat<?, F, ?, I, X, ?, P>> (
        Map<Criterion<DATUM, D, V, F, I, X, P>,Zone[]> criteriaForZones) {}
