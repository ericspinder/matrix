package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class ThreadedAgent<N extends Notion<N,I,X>,I extends Identity<I,X>,X extends Context<X>> extends ThreadLocal<Agent<N,I,X,?>> {

    @SuppressWarnings("all")
    @Override
    protected Agent<N,I,X,?> initialValue() {
        return (Agent<N,I,X,?>) super.initialValue();
    }

    @SuppressWarnings("all")
    @Override
    public Agent<N,I,X,?> get() {
        return (Agent<N,I,X,?>) super.get();
    }
}
