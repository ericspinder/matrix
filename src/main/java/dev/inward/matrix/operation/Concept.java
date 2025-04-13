/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.operation;

import dev.inward.matrix.addressed.*;
import dev.inward.matrix.file.addressed.*;
import dev.inward.matrix.file.addressed.info.Persona;

import java.net.URL;
import java.util.List;

public abstract class Concept<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends AddressedReference<PATH,ID,I,A,R,F>,F extends AddressedView<PATH,ID,I,A,R,F>,C extends Concept<PATH,ID,I,A,R,F,C>> extends Operation<PATH,ID,I,A,R,F,C> {


    public Concept(URL url, Persona persona) {
        super(url, persona);
    }


    public static class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends AddressedReference<PATH,ID,I,A,R,F>,F extends AddressedView<PATH,ID,I,A,R,F>,C extends Concept<PATH,ID,I,A,R,F,C>> extends dev.inward.matrix.Gathering<PATH,ID,I,A,R,C> {

        public Gathering(AddressedSteward<PATH, ID, I, A, PR, R> resource, List<Concept<PATH, ID, I, A, PR, R>> containers) {
            super(resource, containers);
        }
    }

}
