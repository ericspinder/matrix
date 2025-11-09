/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Provider<TARGET> implements Iterator<TARGET> {

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
    public abstract TARGET current();

    public static class Provided<TARGET> extends Provider<TARGET> {

        protected TARGET target;

        public Provided(boolean autoReset, boolean cancelWhenResetIsFalse, TARGET target) {
            super(autoReset, cancelWhenResetIsFalse);
            this.target = target;
        }

        @Override
        public boolean hasNext() {
            return autoReset;
        }

        @Override
        public TARGET next() {
            return target;
        }

        @Override
        public TARGET current() {
            return target;
        }
    }

    public static class Current<TARGET> extends Provider<TARGET> {

        protected TARGET target;
        protected boolean next;
        protected boolean waitForMore;
        private final Lock gate = new ReentrantLock();

        public Current(boolean autoReset, boolean cancelWhenResetIsFalse,TARGET target) {
            super(autoReset,cancelWhenResetIsFalse);
            this.target = target;
        }


        public void setSubject(TARGET target) {
            gate.lock();
            try {
                this.target = target;
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
        public TARGET next() {
            gate.lock();
            try {
                this.next = false;
                return this.target;
            }
            finally {
                gate.unlock();
            }
        }

        @Override
        public TARGET current() {
            return this.target;
        }
    }

    public static class Chain<TARGET> extends Provider<TARGET> {

        protected final Deque<TARGET> deque;
        protected boolean waitForMore;

        public Chain(boolean autoReset, boolean cancelWhenResetIsFalse, Deque<TARGET> deque) {
            super(autoReset,cancelWhenResetIsFalse);
            this.deque = deque;
        }

        @Override
        public boolean hasNext() {
            return !this.deque.isEmpty();
        }

        @Override
        public TARGET next() {
            return deque.pop();
        }

        @Override
        public TARGET current() {
            return deque.peek();
        }
    }
}
