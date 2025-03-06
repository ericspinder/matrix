/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.FileKey;
import dev.inward.matrix.predictable.Criterion;

import javax.annotation.Nullable;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Provider<PATH extends Comparable<PATH>,K extends FileKey<PATH,K>> implements Iterator<K> {

    protected final Criterion criterion;

    public Provider(@Nullable K watched,@Nullable Criterion criterion) {
        this.setInitialValue(watched,criterion);
        this.criterion = criterion;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    protected abstract void setInitialValue(@Nullable K watched, @Nullable Criterion criterion);
    abstract boolean reset();

    public static class Finder<PATH extends Comparable<PATH>,K extends FileKey<PATH,K>> extends Provider<PATH,K> {

        public Finder(@Nullable K watched, @Nullable Criterion criterion) {
            super(watched, criterion);
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return null;
        }

        @Override
        public void remove() {
            super.remove();
        }

        @Override
        protected void setInitialValue(@Nullable K watched, @Nullable Criterion criterion) {

        }

        @Override
        boolean reset() {
            return false;
        }
    }

    public static class Provided<PATH extends Comparable<PATH>,K extends FileKey<PATH,K>> extends Provider<PATH,K> {

        protected K watched;

        public Provided(@Nullable K watched, @Nullable Criterion criterion) {
            super(watched,criterion);
        }

        @Override
        protected void setInitialValue(@Nullable K watched, @Nullable Criterion criterion) {
            this.watched = watched;
        }

        @Override
        boolean reset() {
            return false;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return watched;
        }
    }

    public static class Current<PATH extends Comparable<PATH>,K extends FileKey<PATH,K>> extends Provider<PATH,K> {

        protected K watched;
        protected boolean next;
        private final Lock gate = new ReentrantLock();

        public Current(@Nullable K watched, @Nullable Criterion criterion) {
            super(watched,criterion);
        }

        @Override
        protected void setInitialValue(@Nullable K watched, @Nullable Criterion criterion) {
            this.watched = watched;
            next = watched != null;
        }

        @Override
        boolean reset() {
            return false;
        }

        public void setWatched(K watched) {
            gate.lock();
            try {
                this.watched = watched;
                this.next = true;
            } finally {
                gate.unlock();
            }
        }

        @Override
        public boolean hasNext() {
            return next;
        }

        @Override
        public K next() {
            gate.lock();
            try {
                this.next = false;
                return this.watched;
            }
            finally {
                gate.unlock();
            }
        }
    }

    public static class Chain<PATH extends Comparable<PATH>,K extends FileKey<PATH,K>> extends Provider<PATH,K> {

        protected final Deque<K> deque;

        public Chain(Deque<K> deque, @Nullable Criterion criterion) {
            super(deque.getFirst(),criterion);
            this.deque = deque;
        }

        @Override
        protected void setInitialValue(K watched, @Nullable Criterion criterion) {

        }

        @Override
        boolean reset() {
            return true;
        }

        @Override
        public boolean hasNext() {
            return !this.deque.isEmpty();
        }

        @Override
        public K next() {
            return deque.pop();
        }
    }
}
