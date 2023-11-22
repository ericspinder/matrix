package dev.inward.matrix.fact;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;

public interface Addressed<S extends Scheme<S,L>, L extends Library<S,L>, PATH extends Comparable<PATH>, ID extends Comparable<ID>,I extends Identity<S,L,PATH,ID,I,A>,A extends Addressed<S,L,PATH,ID,I,A>> {

    I getIdentity();
}
