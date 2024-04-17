package dev.inward.matrix.fact;

import dev.inward.matrix.*;

import java.net.URL;
import java.util.function.Predicate;

public abstract class Fact<S extends Scheme<S,L>,L extends Library<S,L>,N extends Fact.Named<S,L,N,F>,F extends Fact<S,L,N,F>> extends Concept<S,L,String,String,N,F> {

    protected final short fidelity;

    public Fact(N identity, short fidelity) {
        super(identity);
        this.fidelity = fidelity;
    }

    public short getFidelity() {
        return fidelity;
    }

    public Fact<S,L,N,F> F reduce(Fact<S,L,N,F> next...) {

    }
    public static class Query<S extends Scheme<S,L>,L extends Library<S,L>,Q extends Query<S,L,Q,F>,F extends Fact<S,L,Q,F>> extends Tangible<S,L,URL,String,Q,F> {

    }


    public abstract static class Named<S extends Scheme<S,L>,L extends Library<S,L>,N extends Named<S,L,N,F>,F extends Fact<S,L,N,F>> extends Tangible<S,L,String,String,N,F> {

        protected final char persona;
        public Named(String name, char persona) {
            super(name);
            this.persona = persona;
        }
        public static class DotExtension<S extends Scheme<S,L>,L extends Library<S,L>,F extends Fact<S,L,DotExtension<S,L,F>,F>> extends Named<S,L,DotExtension<S,L,F>,F> {

            protected final String extension;

            public DotExtension(String name, String extension) {
                super(name);
                this.extension = extension;
            }

            @Override
            public String toString() {
                return this.id + '.' + this.extension;
            }

            @Override
            public int compareTo(DotExtension<S, L, F> that) {
                int isZero = this.id.compareTo(that.id);
                if (isZero == 0) {
                    return this.extension.compareTo(that.extension);
                }
                return isZero;
            }
        }
        public static class Simple<S extends Scheme<S,L>,L extends Library<S,L>,F extends Fact<S,L,Simple<S,L,F>,F>> extends Named<S,L,Simple<S,L,F>,F> {

            public Simple(String name) {
                super(name);
            }

            @Override
            public String toString() {
                return this.id.toString();
            }

            @Override
            public int compareTo(Simple<S, L, F> that) {
                return this.id.compareTo(that.id);
            }
        }

    }
}
