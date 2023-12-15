package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.User;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.personality.Persona;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Path;
import java.util.*;

public abstract class Identity<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<S,L,PATH,ID,I,A>,A extends Addressed<S,L,PATH,ID,I,A>> implements Comparable<I> {

    public static final char Aforementioned = '\u0000';

    protected final ID id;

    public abstract S getScheme();
    public abstract Terrene getTerrene();
    public abstract Domain getDomain();
    public abstract char getSigil();
    public abstract PATH getPath();
    public abstract String toString();

    public static class Ethereal<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,Q extends Query<S,L,PATH,ID,Q>> extends Identity<S,L,PATH,ID,Ethereal<S,L,PATH,ID,Q>,Q> {

        protected final L library;
        protected final char sigil;
        protected final PATH path;
        protected final String query;

        public Ethereal(@Nonnull ID id,@Nonnull L library, @Nonnull char sigil,@Nullable PATH path, @Nullable String fileName, @Nullable String query) {
            super(id);
            this.library = library;
            this.sigil = sigil;
            this.path = path;
            this.query = query;
        }

        @Override
        public PATH getPath() {
            return this.path;
        }

        @Override
        public S getScheme() {
            return this.library.scheme;
        }

        @Override
        public Terrene getTerrene() {
            return this.library.terrene;
        }

        @Override
        public Domain getDomain() {
            return this.library.domain;
        }

        public char getSigil() {
            return sigil;
        }

        public String getQuery() {
            return query;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(library.scheme.scheme).append(library.terrene.getSchema()).append(library.domain.);
            if (this.path != null) {
                stringBuilder.append(this.path);
            }
            if (this.sigil != Aforementioned || Character.isIdentifierIgnorable(this.sigil)) {
                stringBuilder.append(this.sigil);
            }
            if (this.query != null) {
                stringBuilder.append(this.query);
            }
            return  stringBuilder.toString();
        }

        @Override
        public int compareTo(Ethereal<S,L,PATH,ID,Q> that) {
            return 0;
        }
    }

    public static class Ego<S extends Scheme<S,L>,L extends Library<S,L>,P extends Persona<S,L,P>> extends Identity<S,L,Domain,Character, Ego<S,L,P>,P> {

        protected final S scheme;
        protected final Terrene terrene;
        protected final Domain domain;

        public Ego(Character persona, S scheme, Terrene terrene, Domain domain) {
            super(persona);
            this.scheme = scheme;
            this.terrene = terrene;
            this.domain = domain;
        }

        @Override
        public S getScheme() {
            return scheme;
        }

        @Override
        public Terrene getTerrene() {
            return terrene;
        }

        @Override
        public char getSigil() {
            return this.id;
        }

        @Override
        public Domain getDomain() {
            return this.domain;
        }

        @Override
        public Domain getPath() {
            return this.domain;
        }

        @Override
        public String toString() {
            return this.id + "@" + this.domain;
        }

        @Override
        public int compareTo(Ego<S, L, P> that) {
            int isZero = this.id.compareTo(that.id);
            if (isZero == 0) {
                return this.domain.compareTo(that.domain);
            }
            return isZero;
        }
    }
    public abstract static class Tangible<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Identity<S,L,PATH,ID,T,C> {

        public Tangible(ID id) {
            super(id);
        }

        @SuppressWarnings("unchecked")
        public Context<S,L,PATH,ID,T,C,?> getContext() {
            return ((Context<S,L,PATH,ID,T,C,?>)this.id.getClass().getProtectionDomain());
        }
        public Catalog<S,L,PATH,ID,T,C,?> getCatalog() {
            return this.getContext().catalog;
        }

        @Override
        public Domain getDomain() {
            return this.getCatalog().getLibrary().getDomain();
        }

        @Override
        public S getScheme() {
            return this.getCatalog().getLibrary().scheme;
        }

        @Override
        public char getSigil() {
            return this.getCatalog().getSigil();
        }

        @Override
        public PATH getPath() {
            return ((Factory<S,L,PATH,ID,T,C>)this.getContext().getClassLoader()).getGathering().getPath();
        }

        @Override
        public Terrene getTerrene() {
            return this.getCatalog().getLibrary().getTerrene();
        }

        public static class Alias<S extends Scheme<S,L>,L extends Library<S,L>,P extends Persona<S,L,P,H>,H extends Identity.Ego<S,L,P>> extends Tangible<S,L, Path,String, Alias<S,L,P,PROFILE>,P> {

            protected char persona;
            protected String name;
            protected final Profile<S,L,?> profile;

            public Alias(char persona, String name,Profile<S,L,?> profile) {
                super(name);
                this.persona = persona;
                this.profile = profile;
            }


            public char getPersona() {
                return persona;
            }


            @Override
            public int compareTo(Alias<S, L, P,PROFILE> o) {
                return 0;
            }

            @Override
            public PROFILE getPath() {
                return null;
            }

            @Override
            public String toString() {
                return null;
            }
        }

        public static class Web<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,D extends Gathering<S,L,PATH,D,N,F>,N extends Notion<S,L,PATH,N>,F extends Fact<S,L,PATH,N,F>> extends Tangible<S,L,PATH,PATH,Web<S,L,PATH,D,N,F>,D> {

            public Web(PATH path) {
                super(path);
            }

            @Override
            public int compareTo(Web<S,L,PATH,D,N,F> that) {
                return this.id.compareTo(that.id);
            }
            @Override
            public PATH getPath() {
                return this.id;
            }

            @Override
            public String toString() {
                return null;
            }
        }
        public static class Id2<S extends Scheme<S,L>,L extends Library<S,L>,P extends Persona<S,L,P,H>,H extends dev.inward.matrix.fact.authoritative.notion.house.House> extends Tangible<S,L,H,Character,Id2,P> {

            public Id2(Character character) {
                super(character);
            }

            @Override
            public H getPath() {
                return null;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public int compareTo(Id2 o) {
                return 0;
            }
        }
        public static class Id<S extends Scheme<S,L>,L extends Library<S,L>,N extends Named<S,L,N,F>,F extends Fact<S,L,N,F>,M extends Model<S,L,N,F,M>> extends Tangible<S,L,String,String,Id<S,L,N,F,M>,M> {

            protected final Individual<S,L,?> owner;
            public Id(String s, Individual<S,L,?> owner) {
                super(s);
                this.owner = owner;
            }

            @Override
            public String getPath() {
                return this.getContext().;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public int compareTo(Id<S,L,N,F,M> that) {
                return this.id.compareTo(that.id);
            }
        }

        public static class Gate<S extends Scheme<S,L>,L extends Library<S,L>> extends Tangible<S,L,Path,UUID,Gate<S,L>,Notion<S,L>> {

            public final Profile<S,L,?,?> profile;

            public Gate(UUID uuid, Profile<S,L,?,?> profile) {
                super(uuid);
                this.profile = profile;
            }

            @Override
            public Profile<S,L,?,?> getPath() {
                return this.profile;
            }

            public String toString() {
            }

            @Override
            public int compareTo(Gate<S, L> that) {
                return 0;
            }
        }
        public abstract static class Named<S extends Scheme<S,L>,L extends Library<S,L>,N extends Named<S,L,N,F>,F extends Fact<S,L,N,F>> extends Tangible<S,L,String,String,N,F> {

            public Named(String name) {
                super(name);
            }
            public static class DotExtension<S extends Scheme<S,L>,L extends Library<S,L>,F extends Fact<S,L,DotExtension<S,L,F>,F>> extends Named<S,L, DotExtension<S,L,F>,F> {

                protected final String extension;

                public DotExtension(String name, String extension) {
                    super(name);
                    this.extension = extension;
                }

                @Override
                public int compareTo(DotExtension<S, L, F> that) {
                    return this.toString().compareTo(that.toString());
                }

                @Override
                public String getPath() {
                    return null;
                }

                @Override
                public String toString() {
                    return this.id + '.' + this.extension;
                }
            }
            public static class Simple<S extends Scheme<S,L>,L extends Library<S,L>,F extends Fact<S,L,Simple<S,L,F>,F>> extends Named<S,L,Simple<S,L,F>,F> {

                public Simple(String name) {
                    super(name);
                }

                @Override
                public String getPath() {
                    return null;
                }

                @Override
                public String toString() {
                    return this.id;
                }
                @Override
                public int compareTo(Simple<S,L,F> that) {
                    return this.id.compareTo(that.id);
                }
            }
            protected final Class<F> factClass  = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);;


        }
        public final static class Individual<S extends Scheme<S,L>,L extends Library<S,L>,U extends User<S,L,U>> extends Tangible<S,L,String,String,Individual<S,L,U>,U>  {

            public Individual(String name) {
                super(name);
            }

            @Override
            public String getPath() {
                return this.id;
            }

            @Override
            public String toString() {
                return this.id;
            }

            @Override
            public int compareTo(Individual<S,L,U> that) {
                return 0;
            }
        }
        public static abstract class Rubric<S extends Scheme<S,L>,L extends Library<S,L>,M extends Matter<S,L,M>> extends Tangible<S,L,Indicia,UUID, Rubric<S,L,M>,M> {

            protected final Indicia indicia;
            protected final Map<String,String> initializedMeta;

            public Rubric(UUID uuid, Indicia indicia, Map<String,String> initializedMeta) {
                super(uuid);
                this.indicia = indicia;
                this.initializedMeta = initializedMeta;
            }

            @Override
            public int compareTo(Rubric<S,L,M,C> that) {
                return this.id.compareTo(that.id);
            }

            public final Map<String, String> copyFinalizedMeta() {
                return Map.copyOf(initializedMeta);
            }
        }
        public static class SuperEgo<S extends Scheme<S,L>,L extends Library<S,L>, PROFILE extends Profile<S,L, PROFILE,U>,U extends User<S,L,U>> extends Tangible<S,L,Path,String,SuperEgo<S,L, PROFILE,U>, PROFILE> {

            protected final U user;

            public SuperEgo(String s,U user) {
                super(s);
                this.user = user;
            }

            @Override
            public U getPath() {
                return this.user;
            }

            @Override
            public String toString() {
                return this.id;
            }

            @Override
            public int compareTo(SuperEgo<S,L, PROFILE,U> that) {
                return this.id.compareTo(that.id);
            }
        }
        public final static class Brand<S extends Scheme<S,L>,L extends Library<S,L>,> extends Tangible<S,L,String,String,Brand<S,L,> {

            public Brand(Domain domain) {
                super(domain);
            }

            @Override
            public  getPath() {
                return this.registar     ;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public int compareTo(Brand<S, L, H> o) {
                return 0;
            }
        }

    }

    public Identity(ID id) {
        this.id = id;
    }

    public final ID getId() {
        return id;
    }






//        public interface Indicate extends Meta_I {
//            enum Default implements Indicate {
//                Instructions("instructions", "Instructions for this Web object", true),
//                Citation("citation", "A Web object cited by this Web object in a material way", false),
//                Credit("credit", "Another Web object which shows for whom to give praise or general contact", true),
//                Copyright("copyright", "The copyright of the Web object", true),
//                Impute("impute", "How to complain about this Web object", true);
//
//                final String label;
//                final String description;
//                final boolean cascades;
//
//                /**
//                 * @param label
//                 * @param description
//                 * @param cascades
//                 */
//                Default(String label, String description, boolean cascades) {
//                    this.label = label;
//                    this.description = description;
//                    this.cascades = cascades;
//                }
//
//                @Override
//                public String getLabel() {
//                    return this.label;
//                }
//
//                @Override
//                public String getDescription() {
//                    return this.description;
//                }
//                @Override
//                public boolean cascades() {
//                    return this.cascades;
//                }
//            }
//            boolean cascades();
//        }
//
//        protected final Map<Indicate,Web> relativityMap;
//
//        public Web(PATH path, Map<Indicate,Web> relativityMapSeed) {
//            super(path);
//            this.relativityMap = new ConcurrentHashMap<>(relativityMapSeed);
//        }
//
//        public final Map<Indicate, Web> getRelativityMap() {
//            return relativityMap;
//        }
//
//        @Override
//        public int compareTo(Web<S,L,PATH,D,N> that) {
//            return this.id.compareTo(that.id);
//        }
//    }


}
