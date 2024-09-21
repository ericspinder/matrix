package dev.inward.matrix.fact;

import dev.inward.matrix.Administration;
import dev.inward.matrix.Dogma;
import dev.inward.matrix.Pathway;
import dev.inward.matrix.Range;
import dev.inward.matrix.director.library.Director;

public interface Addressed<PATH extends Comparable<PATH>,D extends Addressed.Directory<PATH,D>,ID extends Comparable<ID>,I extends Addressed.Identity<PATH,D,ID,I,A>,A extends Addressed<PATH,D,ID,I,A>> extends Comparable<A> {

    Dogma userInfo();
    I getIdentity();
    D getDirectory();

    interface Identity<PATH extends Comparable<PATH>,D extends Directory<PATH,D>,ID extends Comparable<ID>,I extends Identity<PATH,D,ID,I,A>,A extends Addressed<PATH,D,ID,I,A>> extends Comparable<I> {

        ID getId();
        PATH getPath();
        A get();
    }

    interface Ledger<PATH extends Comparable<PATH>,D extends Directory<PATH,D>> extends Comparable<Ledger<PATH,D>> {

        Range<PATH> getRange();
        Addressed<PATH,D,?,?,?> resolve(String path_s);
    }
    interface Directory<PATH extends Comparable<PATH>,D extends Directory<PATH,D>> extends Comparable<D> {

        Administration getAdministration();
        Ledger<PATH,D> getLedger();
        PATH getPath();
    }
    interface Administration<> extends Comparable<>

}
