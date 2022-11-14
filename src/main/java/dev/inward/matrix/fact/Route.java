package dev.inward.matrix.fact;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Route<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O,M,T>,B extends Bus<F,I,X,B,R>,R extends Representative<F,I,X,R,?,?>,M extends Matter<M,I,X>,T extends Tolerances<M,T>,P extends Phenomenon<M,T,P>> implements ExecutorService {

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
    public <P> P invokeAny(Collection<? extends Callable<P>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public void execute(Runnable command) {
        this.execute((B) command);
    }
    public void execute(B bus) {

    }
}
