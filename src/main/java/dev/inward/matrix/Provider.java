/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.bureau.*;
import dev.inward.matrix.memory.bureau.*;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Provider<DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,G>,G extends Steward<DATUM,V,M,R,G>> implements Iterator<DATUM> {

    protected boolean autoReset;
    protected boolean cancelWhenResetIsFalse;

    public Provider(boolean autoReset, boolean cancelWhenResetIsFalse) {
        this.autoReset = autoReset;
        this.cancelWhenResetIsFalse = cancelWhenResetIsFalse;
    }

    public boolean isAutoReset() {
        return autoReset;
    }
    public boolean isCancelWhenResetIsFalse() {
        return cancelWhenResetIsFalse;
}
    public abstract DATUM current();

    public static class Provided<DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,G>,G extends Steward<DATUM,V,M,R,G>> extends Provider<DATUM,V,M,R,G> {

        protected DATUM subject;

        public Provided(boolean autoReset, boolean cancelWhenResetIsFalse, DATUM subject) {
            super(autoReset, cancelWhenResetIsFalse);
            this.subject = subject;
        }

        @Override
        public boolean hasNext() {
            return autoReset;
        }

        @Override
        public DATUM next() {
            return subject;
        }

        @Override
        public DATUM current() {
            return subject;
        }
    }

    public static class Current<DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,G>,G extends Steward<DATUM,V,M,R,G>> extends Provider<DATUM,V,M,R,G> {

        protected DATUM subject;
        protected boolean next;
        protected boolean waitForMore;
        private final Lock gate = new ReentrantLock();

        public Current(boolean autoReset, boolean cancelWhenResetIsFalse,DATUM subject) {
            super(autoReset,cancelWhenResetIsFalse);
            this.subject = subject;
        }


        public void setSubject(DATUM subject) {
            gate.lock();
            try {
                this.subject = subject;
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
        public DATUM next() {
            gate.lock();
            try {
                this.next = false;
                return this.subject;
            }
            finally {
                gate.unlock();
            }
        }

        @Override
        public DATUM current() {
            return this.subject;
        }
    }

    public static class Chain<DATUM,V extends View<DATUM,M>,M extends Model<DATUM>,R extends Reference<DATUM,V,M,R,G>,G extends Steward<DATUM,V,M,R,G>> extends Provider<DATUM,V,M,R,G> {

        protected final Deque<DATUM> deque;
        protected boolean waitForMore;

        public Chain(boolean autoReset, boolean cancelWhenResetIsFalse, Deque<DATUM> deque) {
            super(autoReset,cancelWhenResetIsFalse);
            this.deque = deque;
        }

        @Override
        public boolean hasNext() {
            return !this.deque.isEmpty();
        }

        @Override
        public DATUM next() {
            return deque.pop();
        }

        @Override
        public DATUM current() {
            return deque.peek();
        }
    }
    public static class KeyedSearch<BK extends BureauKey<BK,BI,BV,BM,BR,BG>,BI extends Bureau<BK,BI,BV,BM,BR,BG>,BV extends BureauView<BK,BI,BV,BM,BR,BG>,BM extends BureauModel<BK,BI,BV,BM,BR,BG>,BR extends BureauReference<BK,BI,BV,BM,BR,BG>,BG extends BureauSteward<BK,BI,BV,BM,BR,BG>, K extends MatrixKey<K,I,V,M,R, G>,I extends MatrixItem<K,I,V,M,R,G>,V extends View<I,M>,M extends Model<I>,R extends Reference<I,V,M,R,G>,G extends Steward<I,V,M,R,G>> extends Provider<I,V,M,R,G> {
        public KeyedSearch(boolean autoReset, boolean cancelWhenResetIsFalse) {
            super(autoReset, cancelWhenResetIsFalse);
        }
    }
}
