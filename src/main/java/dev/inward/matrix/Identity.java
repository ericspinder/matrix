package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.*;

public abstract class Identity<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<S,L,PATH,ID,I,A>,A extends Addressed<S,L,PATH,ID,I,A>> {

    public static final char Aforementioned = '\u0000';

    protected final ID id;
    public abstract S getScheme();
    public abstract Terrene getTerrene();
    public abstract Domain getDomain();
    public abstract Pathway<S,L,PATH> getPathway();
    public abstract String toString();

    public Identity(ID id) {
        this.id = id;
    }

    public final ID getId() {
        return id;
    }



//
//        protected final Map<Indicate,Web> relativityMap;
//
//        public Web(PATH path, Map<Indicate,Web> relativityMapSeed) {
//            super(path);
//            this.relativityMap = new ConcurrentHashMap<>(relativityMapSeed);
//        }
//
//        public final Map<Indicate, Web> getRelativityMap() {
//            return relativityMap;
//        }
//
//        @Override
//        public int compareTo(Web<S,L,PATH,D,N> that) {
//            return this.id.compareTo(that.id);
//        }
//    }


}
