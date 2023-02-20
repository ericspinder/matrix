package dev.inward.matrix.fact.tracked;

import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Envoy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.function.BiConsumer;

public abstract class Controller<F extends Fact<F,I,ID,VERISON,X>,I extends Identity<I,ID,VERISON,X>,ID extends Comparable<ID>,VERISON extends Comparable<VERISON>,X extends Context<VERISON,X>,EXPIRE extends Comparable<EXPIRE>,C extends Controller<F,I,ID,VERISON,X,EXPIRE,C,B,V>,B extends Bus<F,I,ID,VERISON,X,B,?>,V extends Envoy<?,V>> implements Comparable<C>, BiConsumer<VERISON,EXPIRE> {

    public Controller()  {
    }

    public static class Default extends Controller<String,Instant,Default> {

        protected final String version;
        protected final Instant expire;
        public Default(@Nullable String version, @Nonnull Instant expire) {
            this.version = version;
            this.expire = expire;
        }

        @Override
        public int compareTo(Default that) {
            int isZero = this.version.compareTo(that.version);
            if (isZero == 0) {
                return this.expire.compareTo(that.expire);
            }
            return isZero;
        }

        @Override
        public void accept(String s, Instant instant) {
            this.expire = expire;
            this.version = instant;
        }

        @Override
        public BiConsumer<String, Instant> andThen(BiConsumer<? super String, ? super Instant> after) {
            return super.andThen(after);
        }
    }
    public static class Matrix extends Controller<String, Instant, Controller.Matrix> {

        public static final Matrix Aforementioned = new Matrix(Instant.MAX,Matrix.Aforementioned);
        protected final Matrix matrixAuthority;

        public Matrix(Matrix matrixAuthority) {
            super();
            this.matrixAuthority = matrixAuthority;
        }

        @Override
        public int compareTo(Controller.Matrix that) {
            int isZero = this.matrixAuthority.compareTo(that.matrixAuthority);;
            if(isZero == 0) {
                return super.compareTo(that);
            }
            return isZero;
        }
    }
    @Override
    public int compareTo(C that) {
        int isZero = this.version.compareTo(that.version);
        if (isZero == 0) {
            return this.expire.compareTo(that.expire);
        }
        return isZero;
    }
}
