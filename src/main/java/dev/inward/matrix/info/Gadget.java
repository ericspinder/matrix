package dev.inward.matrix.info;

import dev.inward.matrix.Materialization;

import java.util.UUID;

public abstract class Gadget<D extends Dogma<D>,A extends Gadget.Address<D,A,G>,G extends Gadget<S,L,D,A,G>> extends Materialization {

    protected final A identity;

    public Gadget(A identity) {
        this.identity = identity;
    }
    @Override
    public A getIdentity() {
        return this.identity;
    }

    public static class Action<D extends Dogma> implements Comparable<Pathway<D>> {

        protected final D dogma;
        protected final String functionName;
        protected Pathway(D dogma, String functionName) {
            this.dogma = dogma;
            this.functionName = functionName;
        }

        @Override
        public int compareTo(Pathway that) {
            int isZero = this.dogma.compareTo(that.dogma);
            if (isZero == 0) {
                return this.function.compareTo(that.function);
            }
            return isZero;
        }
    }

    public static class Address<D extends Dogma<S,L,D>,A extends Address<S,L,D,A,G>,G extends Gadget<S,L,D,A,G>> extends Identity<S,L,D,String,A,G>  {

        protected final UUID instance;
        protected final D dogma;
        public Address(String name,UUID instance, D dogma) {
            super(name);
            this.instance = instance;
            this.dogma = dogma;
        }
    }
}
