package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public abstract class Router<F extends Fact<F,I,X,NI,NX>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,I,X,B,R,N,NI,NX,A,U,P,M,T>,R extends Representative<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>,U extends Router<F,I,X,B,R,N,NI,NX,A,U,P,M,T>,P extends Phenomenon<M,P,T>,M extends Matter<M,I,X>,T extends Tolerances<M,T>> implements ExecutorService {


    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <M> Future<M> submit(Callable<M> task) {
        return null;
    }


    @Override
    public <M> Future<M> submit(Runnable task, M result) {
        return this.submit((B)task,result);
    }
    public P submit(B task, M result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return this.submit((B) task);
    }
    public P submit(B bus) {
        return null;
    }

    @Override
    public <P> List<Future<P>> invokeAll(Collection<? extends Callable<P>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <P> List<Future<P>> invokeAll(Collection<? extends Callable<P>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <P> P invokeAny(Collection<? extends Callable<P>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <P> P invokeAny(Collection<? extends Callable<P>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {
        this.execute((B) command);
    }
    public void execute(B bus) {

    }
}
