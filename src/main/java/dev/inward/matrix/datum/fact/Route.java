package dev.inward.matrix.datum.fact;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.util.concurrent.Executor;

public abstract class Route<F extends Fact<F,I,X,R,NI,NX>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R,N,NI,NX,A,U>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,U extends Route<F,I,X,B,R,N,NI,NX,A,U>> implements Executor {

    @Override
    @SuppressWarnings("all")
    public void execute(Runnable command) {
        this.execute((B)command);
    }
    public void execute(B bus) {

    }
}
