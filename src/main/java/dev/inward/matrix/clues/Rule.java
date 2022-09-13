package dev.inward.matrix.clues;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;

public abstract class Rule<PRACTICE,E extends Effect<?,?,E,?,?>,R extends Rule<PRACTICE,E,R>> extends Policy<PRACTICE,E,Identity.Ego, Context.JVM,R> {

    public Rule(E effect,Identity.Ego ego) {
        super(effect, ego);
    }

    public Rule(PRACTICE BEHAVIOR) {
        super(BEHAVIOR);
    }


}
