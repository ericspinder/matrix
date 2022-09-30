package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.util.Map;

/**
 *
 * @param <DATUM>
 * @param <F>
 * @param <I>
 * @param <X>
 */
public record Criteria<DATUM> (
        Map<Criterion<DATUM>,Zone[]> criteriaForZones) {}
