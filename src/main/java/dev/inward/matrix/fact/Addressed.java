package dev.inward.matrix.fact;

import dev.inward.matrix.*;

import java.lang.ref.Reference;
import java.util.function.Function;

public abstract class Addressed<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representitive<PATH,ID,I,A,R>> implements Datum<A,R>, Comparable<A> {

    protected final I identity;

    public Addressed(I identity) {
        this.identity = identity;
    }

    public I getIdentity() {
        return identity;
    }

    public static class Resource<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representitive<PATH,ID,I,A,R>> extends dev.inward.matrix.Resource<A,R> {

        public Resource(Representitive<?,?,?,?,?> parent, String className, long warnOnTotal, long hardLimit, Function<Reference<? extends A>,Reference<? extends A>> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }


//    interface Permit<P extends Permit<P,SUBJECT>,SUBJECT> extends Comparable<P> {
//
//        String PERMIT_PROPERTY = "permit";
//        UUID getUuid();
//        Dogma.Agent getOwner();
//        Dogma.House getHouse();
//
//        List<Rule> getRules();
//
//        boolean allowAccess(Dogma.Persona persona, AclEntryPermission requestedPermission);
//        void notify(Noted noted);
//        void process(Exception exception);
//    }
//
//    interface Noted {
//        String getNote();
//    }

}
