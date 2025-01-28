package dev.inward.matrix.operation;

import dev.inward.matrix.Addressed;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Representative;
import dev.inward.matrix.info.Persona;

import java.net.URL;
import java.util.*;

public abstract class Concept<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>,C extends Concept<PATH,ID,I,A,R,F,C>> extends Operation<PATH,ID,I,A,R,F,C> {


    public Concept(URL url, Persona persona) {
        super(url, persona);
    }


    public static class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>,C extends Concept<PATH,ID,I,A,R,F,C>> extends dev.inward.matrix.Gathering<PATH,ID,I,A,R,C> {

        public Gathering(Addressed.Resource<PATH, ID, I, A, PR, R> resource, List<Concept<PATH, ID, I, A, PR, R>> containers) {
            super(resource, containers);
        }
    }

}
