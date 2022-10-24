package dev.inward.matrix.engine;

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
