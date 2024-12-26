package dev.inward.matrix;

import java.net.URL;
import java.util.*;

public abstract class Concept<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representative<PATH,ID,I,A,R>,C extends Concept<PATH,ID,I,A,R,C>> extends Operation<PATH,ID,I,A,R,C> {


    public Concept(URL url) {
        super(url);
    }


    public static class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representative<PATH,ID,I,A,R>,C extends Concept<PATH,ID,I,A,R,C>> extends dev.inward.matrix.Gathering<PATH,ID,I,A,R,C> {

        public Gathering(Addressed.Resource<PATH, ID, I, A, PR, R> resource, List<Concept<PATH, ID, I, A, PR, R>> containers) {
            super(resource, containers);
        }
    }

}
