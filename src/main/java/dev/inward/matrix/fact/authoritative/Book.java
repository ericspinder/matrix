package dev.inward.matrix.fact.authoritative;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public abstract class Book<PAGES extends Comparable<PAGES>, B extends Book<PAGES, B,TITLE>,TITLE extends Comparable<TITLE>> implements Collection<PAGES>,Comparable<B> {

    protected final TITLE title;

    public static class Pamphlet extends Book<String, Pamphlet,String> {

        public Pamphlet(String s) {
            super(s);
        }
    }

    public Book(TITLE title) {
        this.title = title;
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
    public Iterator<PAGES> iterator() {
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
    public boolean add(PAGES PAGES) {
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
    public boolean addAll(Collection<? extends PAGES> c) {
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

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return Collection.super.toArray(generator);
    }

    @Override
    public Stream<PAGES> stream() {
        return Collection.super.stream();
    }

    @Override
    public void forEach(Consumer<? super PAGES> action) {
        Collection.super.forEach(action);
    }
    @Override
    public int compareTo(B that) {
        return this.title.compareTo(that.title);
    }
}
