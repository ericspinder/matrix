package dev.inward.matrix.operation;

import dev.inward.matrix.Addressed;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Representative;

public class Notion<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>,N extends Notion<PATH,ID,I,A,R,F,N>> extends Operation<PATH,ID,I,A,R,F,N> {

}
