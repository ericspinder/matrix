package dev.inward.matrix.info;

import dev.inward.matrix.*;

import java.security.Principal;
import java.util.*;
import java.util.function.Function;

public abstract class Dogma<I extends Dogma.Identity<I,D,R,F>,D extends Dogma<I,D,R,F>,R extends Dogma.Representative<I,D,R,F>,F extends Dogma.DogmaAttributes<I,D,R,F>> extends Addressed<Path_ofInfo,String,I,D,R,F> implements Principal {

    public static class Identity<I extends Dogma.Identity<I,D,R,F>,D extends Dogma<I,D,R,F>,R extends Dogma.Representative<I,D,R,F>,F extends DogmaAttributes<I,D,R,F>> extends dev.inward.matrix.Identity<Path_ofInfo,String,I,D,R,F> {

        public Identity(String s, Index<Path_ofInfo> index) {
            super(s, null, index);
        }

        @Override
        public Library<?, ?, Path_ofInfo> getLibrary() {
            return null;
        }


    }
    public static class Representative<I extends Dogma.Identity<I,D,R,F>,D extends Dogma<I,D,R,F>,R extends Dogma.Representative<I,D,R,F>,F extends DogmaAttributes<I,D,R,F>> extends dev.inward.matrix.Representative<Path_ofInfo,String,I,D,R,F> {

        public Representative(D addressed, Dogma.Resource<I,D,R,F> resource) {
            super(addressed, resource);
        }
    }

    public Dogma(I identity) {
        super(identity);
    }

    @Override
    public String getName() {
        return this.getFileKey().toString();
    }

    @Override
    public int compareTo(D that) {
        return this.getFileKey().compareTo(that.getFileKey());
    }

    public static class DogmaAttributes<I extends Dogma.Identity<I,D,R,F>,D extends Dogma<I,D,R,F>,R extends Dogma.Representative<I,D,R,F>,F extends DogmaAttributes<I,D,R,F>> extends dev.inward.matrix.Addressed.FileAttributes<Path_ofInfo,String,I,D,R,F> {

        public DogmaAttributes(Properties properties, long size) {
            super(properties, size);
        }

    }
    public static class Resource<I extends Dogma.Identity<I,D,R,F>,D extends Dogma<I,D,R,F>,R extends Dogma.Representative<I,D,R,F>,F extends DogmaAttributes<I,D,R,F>> extends Addressed.Resource<Path_ofInfo,String,I,D,R,F> {

        public Resource(Standard standard, Function<R, R> graveDigger, Specification specification) {
            super(standard, graveDigger, specification);
        }
    }
}
