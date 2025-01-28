package dev.inward.matrix;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Properties;
import java.util.function.Function;

public abstract class Addressed<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>> implements Datum<A,R,F>, MatrixFile<PATH,I,A,F> {

    protected final I identity;
    public Addressed(I identity) {
        this.identity = identity;
    }

    @Override
    public I getFileKey() {
        return identity;
    }

    public static class Resource<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends FileAttributes<PATH,ID,I,A,R,F>> extends dev.inward.matrix.DatumResource<A,R,F> {

        protected final Specification specification;
        public Resource(Standard standard, Function<R,R> graveDigger, Specification specification) {
            super(standard, graveDigger);
            this.specification = specification;
        }
    }

    public static class FileAttributes<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends FileAttributes<PATH,ID,I,A,R,F>> extends dev.inward.matrix.DatumAttributes<A,R,F> implements dev.inward.matrix.FileAttributes<PATH,I,A,F> {

        protected final long fileSize;
        public FileAttributes(Properties properties, long fileSize) {
            super(properties);
            this.fileSize = fileSize;
        }

        @Override
        public FileTime lastModifiedTime() {
            return (FileTime) this.getProperties().get("lastModifiedTime");
        }

        @Override
        public FileTime lastAccessTime() {
            return (FileTime) this.getProperties().get("lastAccessTime");
        }

        @Override
        public FileTime creationTime() {
            return (FileTime) this.getProperties().get("creationTime");
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

        @Override
        public long size() {
            return this.fileSize;
        }

        @Override
        public Object fileKey() {
            return this.properties.get("identity");
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
