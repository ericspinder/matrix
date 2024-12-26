package dev.inward.matrix;

import java.util.function.Function;

public abstract class Addressed<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>> extends MatrixFile<PATH,I,A,R,F> {

    public Addressed(I identity) {
        super(identity);
    }

    public static class Resource<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends FileAttributes<PATH,ID,I,A,R,F>> extends MatrixFile.Resource<PATH,I,A,R,F> {

        public Resource(Representative<?,?,?,?,?,?> parent, String className, long warnOnTotal, long hardLimit, Function<R,R> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }
    public static class FileAttributes<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends FileAttributes<PATH,ID,I,A,R,F>> extends dev.inward.matrix.FileAttributes<PATH,I,A,R,F> {

        public FileAttributes(A datum) {
            super(datum);
        }

        @Override
        public boolean isRegularFile() {
            return true;
        }

        @Override
        public boolean isDirectory() {
            return false;
        }

        @Override
        public boolean isSymbolicLink() {
            return false;
        }

        @Override
        public boolean isOther() {
            return false;
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
