package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;

import java.net.URL;
import java.util.*;

public abstract class Concept<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,PR,R>,A extends Addressed<PATH,ID,I,A,PR,R>,PR extends Representitive<PATH,?,?,?,?,PR>,R extends Representitive<PATH,ID,I,A,PR,R>> extends Operation<PATH,ID,I,A,PR,R> {


    public Concept(URL url, Properties properties) {
        super(url, properties);
    }


    public static class Gathering<PATH extends Comparable<PATH>, ID extends Comparable<ID>, I extends Identity<PATH, ID, I, A, PR, R>, A extends Addressed<PATH, ID, I, A, PR, R>, PR extends Representitive<PATH, ?, ?, ?, ?, PR>, R extends Representitive<PATH, ID, I, A, PR, R>> extends dev.inward.matrix.director.library.catalog.Gathering<PATH, ID, I, A, PR, R, Concept<PATH, ID, I, A, PR, R>> {

        public Gathering(Addressed.Resource<PATH, ID, I, A, PR, R> resource, List<Concept<PATH, ID, I, A, PR, R>> containers) {
            super(resource, containers);
        }
    }

}
