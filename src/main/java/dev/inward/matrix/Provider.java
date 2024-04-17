package dev.inward.matrix;

import dev.inward.matrix.fact.*;
import dev.inward.matrix.concept.matter.Indicia;

import java.util.Queue;
import java.util.concurrent.locks.StampedLock;

public abstract class Provider<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>>  {

    private boolean on = true;
    public Provider() {

    }

    public abstract C getConcept();

    public final void off() {
        this.on = false;
    }
    public final boolean isOn() {
        return on;
    }

    public static final class Provided<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Provider<S,L,PATH,ID,T,C> {

        protected final C concept;

        public Provided(C concept) {
            super();
            if (concept == null) throw new NullPointerException("Provided Context is null");
            this.concept = concept;
        }
        @Override
        public C getConcept() {
            if (isOn()) return this.concept;
            return null;
        }

    }
    public static final class Soft<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Provider<S,L,PATH,ID,T,C> {

        protected final Representative<S,L,PATH,ID,T,C> representative;

        public Soft(Representative<S,L,PATH,ID,T,C> representative) {
            super();
            this.representative = representative;
        }

        @Override
        public C getConcept() {
            if (isOn()) return representative.get();
            return null;
        }

    }
    public static final class Current<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Provider<S,L,PATH,ID,T,C> {

        private C concept;
        private final StampedLock gate = new StampedLock();

        public Current(C concept) {
            super();
            this.setConcept(concept);
        }
        public void setConcept(C concept) {
            if (isOn()) {
                long writeLock = gate.writeLock();
                try {
                    this.concept = concept;
                } finally {
                    gate.unlockWrite(writeLock);
                }
            }
            throw new MatrixException(MatrixException.Type.CurrentNotSet,"Current",Indicia.Focus.Admonitory, Indicia.Severity.Critical,new Exception(concept.getIdentity().toString()));
        }
        @Override
        public C getConcept() {
            long readLock = gate.readLock();
            try {
                if (isOn()) return this.concept;
            }
            finally {
                gate.unlockRead(readLock);
            }
            return null;
        }
    }
    public static final class Chain<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Provider<S,L,PATH,ID,T,C> {

        protected final Queue<C> queue;

        public Chain(Queue<C> queue) {
            this.queue = queue;
        }

        @Override
        public C getConcept() {
            if (isOn()) return this.queue.peek();
            return null;
        }
    }
}
