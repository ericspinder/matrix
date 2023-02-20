package dev.inward.matrix.fact;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.resources.Resource;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

public class View<DATUM,E extends Envoy<DATUM,E>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> extends Thread implements Collection<View> {

    protected AtomicBoolean run;
    protected final LinkedBlockingDeque<Item> envoys = new LinkedBlockingDeque<>();

    public static class Item extends Matter

    public View(Resource<DATUM> resource) {
    }
    @Override
    public void run() {
        while(this.run.get()) {
            try {
                BiConsumer<E,I> biConsumer = envoys.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final E getEnvoy() {
        return envoy;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<View> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(View view) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends View> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
