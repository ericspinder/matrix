package dev.inward.matrix.fact;

import java.io.IOException;
import java.lang.ref.Reference;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Properties;
import java.util.function.Function;

public abstract class Fact<PATH extends Comparable<PATH>,I extends Fact.Identity<PATH,I,F,R>,F extends Fact<PATH,I,F,R>,R extends Fact.Representitive<PATH,I,F,R>> extends Addressed<PATH,String,I,F,R> {

    public Fact(I identity) {
        super(identity);
    }

    public static class Representitive<PATH extends Comparable<PATH>,I extends Fact.Identity<PATH,I,F,R>,F extends Fact<PATH,I,F,R>,R extends Representitive<PATH,I,F,R>> extends dev.inward.matrix.Representitive<PATH,String,I,F,R> {

        public Representitive(F addressed, Fact.Resource<PATH,I,F,R> resource, Addressed<PATH,?,?,?,?> parent, boolean hold, Properties properties) {
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
    public abstract static class Identity<PATH extends Comparable<PATH>,I extends Fact.Identity<PATH,I,F,R>,F extends Fact<PATH,I,F,R>,R extends Representitive<PATH,I,F,R>> extends dev.inward.matrix.Identity<PATH,String,I,F,R> {

        public Identity(String id) {
            super(id);
        }

        public abstract String getName();


        public static class DotExtension<PATH extends Comparable<PATH>,F extends Fact<PATH,DotExtension<PATH,F,R>,F,R>,R extends Representitive<PATH,DotExtension<PATH,F,R>,F,R>> extends Identity<PATH,DotExtension<PATH,F,R>,F,R> {

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
        public static class Simple<PATH extends Comparable<PATH>,F extends Fact<PATH,Simple<PATH,F,R>,F,R>,R extends Representitive<PATH,Simple<PATH,F,R>,F,R>> extends Identity<PATH,Simple<PATH,F,R>,F,R> {

            public Simple(String name) {
                super(name);
            }

            @Override
            public String getName() {
                return this.id;
            }

        }

    }

    public abstract static class Resource<PATH extends Comparable<PATH>,I extends Fact.Identity<PATH,I,F,R>,F extends Fact<PATH,I,F,R>,R extends Representitive<PATH,I,F,R>> extends Addressed.Resource<PATH,String,I,F,R> {
        public Resource(dev.inward.matrix.Representitive<PATH, ?, ?, ?, ?> parent, String className, long warnOnTotal, long hardLimit, Function<Reference<? extends F>, Reference<? extends F>> graveDigger) {
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
}
