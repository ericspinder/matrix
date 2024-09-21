package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Startup;
import dev.inward.matrix.Policy;
import dev.inward.matrix.resources.Supplier;

import java.util.HashMap;
import java.util.Map;

public abstract class Fact<N extends Fact.Named<N,F,M>,F extends Fact<N,F,M>,M extends Model<N,F,M>> extends Concept<String, Fact.Pathway,String,N,F> {

    public Fact(N identity) {
        super(identity);
    }

    public final static class Pathway extends dev.inward.matrix.Pathway<String,Pathway> {

        public Pathway(Ledger<String,Pathway> ledger, String path) {
            super(ledger,path);
        }

        @Override
        public String getPathString() {
            return this.path;
        }
    }
    public abstract static class Named<N extends Named<N,F,M>,F extends Fact<N,F,M>,M extends Model<N,F,M>> extends Tangible<String,Pathway,String,N,F> {

        protected final M model;

        public Named(String name) {
            super(name);
        }

        public abstract String getName();


        public static class DotExtension<F extends Fact<DotExtension<F>,F>> extends Named<DotExtension<F>,F> {

            protected final String extension;

            public DotExtension(String name, String extension) {
                super(name);
                this.extension = extension;
            }

            @Override
            public String getName() {
                return this.getId() + '.' + this.extension;
            }

        }
        public static class Simple<S extends Scheme<S,L>,L extends Library<S,L>,F extends Fact<S,L,Simple<S,L,F>,F>> extends Named<S,L,Simple<S,L,F>,F> {

            public Simple(String name,char persona) {
                super(name,persona);
            }

            @Override
            public String getName() {
                return this.id;
            }

        }

    }

    public abstract static class Resource<N extends Named<N,F,M>,F extends Fact<N,F,M>,M extends Model<N,F,M>> extends Concept.Resource<Scheme.HTML,Library.HTML, Fact.Pathway,String,N,F, CardCatalog<N,F>> {

        private Supplier supplier;
        private final Map<String,? super dev.inward.matrix.Resource<?,S,L,PATH,C>> datumMap = new HashMap<>();

        public Resource(Policy[] policies) {
            super(policies);
        }

        @SuppressWarnings("unchecked")
        public <DATUM> dev.inward.matrix.Resource<DATUM,S,L,PATH,F> getResource(Class<DATUM> datumClass) {
            dev.inward.matrix.Resource<DATUM,S,L,PATH,F> resource = (dev.inward.matrix.Resource<DATUM,S,L,PATH,F>) datumMap.get(datumClass.getCanonicalName());
            if (resource == null) {
                datumMap.put(Startup.root().get().newResource(datumClass)
            }
        }


    }
}
