package dev.inward.matrix.http;

import dev.inward.matrix.Addressed;

import java.io.IOException;
import java.lang.ref.Reference;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Properties;
import java.util.function.Function;

public abstract class Fact<I extends Fact.Identity<I,F,R,A>,F extends Fact<I,F,R,A>,R extends Fact.Representative<I,F,R,A>,A extends Fact.FileAttributes<I,F,R,A>> extends Addressed<String,String,I,F,R,A> {

    public Fact(I identity) {
        super(identity);
    }

    public static class Representative<I extends Fact.Identity<I,F,R,A>,F extends Fact<I,F,R,A>,R extends Fact.Representative<I,F,R,A>,A extends Fact.FileAttributes<I,F,R,A>> extends dev.inward.matrix.Representative<String,String,I,F,R,A> {

        public Representative(F addressed, Fact.Resource<I,F,R,A> resource, Addressed<?,?,?,?,?,?> parent, boolean hold, Properties properties) {
            super(addressed, resource, parent, hold, properties);
        }

        @Override
        public Instant lastSync() {
            return null;
        }

        @Override
        public BasicFileAttributes readAttributes() throws IOException {
            return null;
        }

        @Override
        public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

        }
    }
    public abstract static class Identity<I extends Fact.Identity<I,F,R,A>,F extends Fact<I,F,R,A>,R extends Fact.Representative<I,F,R,A>,A extends Fact.FileAttributes<I,F,R,A>> extends dev.inward.matrix.Identity<String,String,I,F,R,A> {

        protected final boolean queryIdentifier;
        public Identity(String id, boolean queryIdentifier) {
            super(id);
            this.queryIdentifier = queryIdentifier;
        }

        public abstract String getName();

        public boolean isQueryIdentifier() {
            return queryIdentifier;
        }


        public static class DotExtension<PATH extends Comparable<PATH>,F extends Fact<PATH,DotExtension<PATH,F,R>,F,R>,R extends Representative<PATH,DotExtension<PATH,F,R>,F,R>> extends Identity<PATH,DotExtension<PATH,F,R>,F,R> {

            protected final String extension;

            public DotExtension(String id, String extension) {
                super(id);
                this.extension = extension;
            }

            @Override
            public String getName() {
                return this.getId() + '.' + this.extension;
            }

        }
        public static class Simple<PATH extends Comparable<PATH>,F extends Fact<PATH,Simple<PATH,F,R>,F,R>,R extends Representative<PATH,Simple<PATH,F,R>,F,R>> extends Identity<PATH,Simple<PATH,F,R>,F,R> {

            public Simple(String name) {
                super(name);
            }

            @Override
            public String getName() {
                return this.id;
            }

        }

    }

    public abstract static class Resource<I extends Fact.Identity<I,F,R,A>,F extends Fact<I,F,R,A>,R extends Representative<I,F,R,A>,A extends Fact.FileAttributes<I,F,R,A>> extends Addressed.Resource<String,String,I,F,R,A> {
        public Resource(dev.inward.matrix.Representative<PATH, ?, ?, ?, ?> parent, String className, long warnOnTotal, long hardLimit, Function<Reference<? extends F>, Reference<? extends F>> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }


//        @SuppressWarnings("unchecked")
//        public <DATUM> dev.inward.matrix.Resource<DATUM,S,L,PATH,F> getResource(Class<DATUM> datumClass) {
//            dev.inward.matrix.Resource<DATUM,S,L,PATH,F> resource = (dev.inward.matrix.Resource<DATUM,S,L,PATH,F>) datumMap.get(datumClass.getCanonicalName());
//            if (resource == null) {
//                datumMap.put(Startup.root().get().newResource(datumClass)
//            }
//        }


    }

    public static class FileAttributes<I extends Fact.Identity<I,F,R,A>,F extends Fact<I,F,R,A>,R extends Fact.Representative<I,F,R,A>,A extends Fact.FileAttributes<I,F,R,A>> extends Addressed.FileAttributes<String,String,I,F,R,A> {

        public FileAttributes(F fact) {
            super(fact);
        }
    }
}
