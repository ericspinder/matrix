package dev.inward.matrix.code;

import dev.inward.matrix.*;
import dev.inward.matrix.predictable.Predictable;

import java.util.function.Function;

public abstract class Code<I extends Code.Identity<I,C,R,A>,C extends Code<I,C,R,A>,R extends Code.Representative<I,C,R,A>,A extends Code.CodeAttributes<I,C,R,A>> extends Addressed<Path_ofCode,String,I,C,R,A> {


    public Code(I identity) {
        super(identity);
    }

    public static class Identity<I extends Identity<I,C,R,A>,C extends Code<I,C,R,A>,R extends Representative<I,C,R,A>,A extends CodeAttributes<I,C,R,A>> extends dev.inward.matrix.Identity<Path_ofCode,String,I,C,R,A> {

        @SafeVarargs
        public Identity(String s, Query query, Index<Path_ofCode> index) {
            super(s, query, index);
        }

        @Override
        public Predictable newWatchService() {
            return null;
        }
    }

    public static abstract class Representative<I extends Identity<I,C,R,A>,C extends Code<I,C,R,A>,R extends Representative<I,C,R,A>,A extends CodeAttributes<I,C,R,A>> extends dev.inward.matrix.Representative<Path_ofCode,String,I,C,R,A> {

        public Representative(C addressed, Addressed.Resource<Path_ofCode, String, I, C, R, A> resource) {
            super(addressed, resource);
        }
    }
    public static class Resource<I extends Identity<I,C,R,A>,C extends Code<I,C,R,A>,R extends Representative<I,C,R,A>,A extends CodeAttributes<I,C,R,A>> extends Addressed.Resource<Path_ofCode,String,I,C,R,A> {

        public Resource(dev.inward.matrix.Representative<?, ?, ?, ?, ?, ?> parent, String className, long warnOnTotal, long hardLimit, Function<R, R> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }
    public static class CodeAttributes<I extends Identity<I,C,R,A>,C extends Code<I,C,R,A>,R extends Representative<I,C,R,A>,A extends CodeAttributes<I,C,R,A>> extends FileAttributes<Path_ofCode,String,I,C,R,A> {

        public CodeAttributes(C datum) {
            super(datum);
        }
    }

}
