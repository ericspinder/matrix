package dev.inward.matrix.operational;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.util.LinkedHashMap;

public class InductionMap<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P,?,?>> extends LinkedHashMap<Class<?>,Induction<?,?,?,?,F,I,X,P>> {


}
