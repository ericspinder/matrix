package dev.inward.matrix.rubric;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.invoke.MethodHandle;
import java.util.List;
import java.util.Map;

/**
 *
 * @param <DATUM>
 * @param <D>
 * @param <E>
 * @param <F>
 * @param <I>
 * @param <X>
 * @param <P>
 * @param <N>
 * @param <NP>
 * @param <V>
 */
public record Criteria<DATUM, D extends Datum<DATUM, D, E>, E extends Envoy<DATUM, D, E, F, I, X, P, N, NP>, F extends Fact<F, I, X, P>, I extends Identity<I, X>, X extends Context<X>, P extends Diplomat<?, F, ?, I, X, ?, P, N, NP>, N extends Notion<N, I, X, NP>, NP extends Ambassador<?, N, ?, I, X, ?, NP, ?, ?>, V extends DatumVisitor<DATUM, D, E>>(
        V visitor, Map<Criterion<DATUM, D, E, F, I, X, P, N, NP, ?>,Zone[]> criteriaForZones) {}
