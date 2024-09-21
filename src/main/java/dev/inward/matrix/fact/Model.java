package dev.inward.matrix.fact;

import dev.inward.matrix.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class Model<N extends Fact.Named<N,F,M>,F extends Fact<N,F,M>,M extends Model<N,F,M>> extends Concept<String, Model.Pathway,String,Model.Id<N,F,M>,M> {

    public static class Pathway extends dev.inward.matrix.Pathway<String,Pathway> {

        public Pathway(Ledger<String, Pathway> ledger, String s) {
            super(ledger, s);
        }

        @Override
        public String getPathString() {
            return null;
        }
    }
    public static class Id<N extends Fact.Named<N,F,M>,F extends Fact<N,F,M>,M extends Model<N,F,M>> extends Concept.Tangible<String, Model.Pathway,String,Id<N,F,M>,M> {

        public Id(String s) {
            super(s);
        }


        @Override
        public M get() {
            return null;
        }

        @Override
        public int compareTo(Id o) {
            return 0;
        }
    }
    @SuppressWarnings("unchecked")
    protected final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    @SuppressWarnings("unchecked")
    protected final Constructor<F>[] factConstructors = (Constructor<F>[])factClass.getConstructors();
    protected final ConcurrentHashMap<Aspect<S,L,String,String,N,F>,> aspects

    public Model(Tangible.Id<S,L,N,F,M> id, Aspect<S,L,String,String,N,F>[] aspects) {
        super(id);

    }

//    public boolean isCreate() {
//        return create;
//    }
//
//    public F create(Identity.Ego<S,L,PATH,F,N> ego) {
//        Dogma.Persona persona = ego.getGetPersona();
//        if (create) {
//            try {
//                return factConstructors[0].newInstance(ego);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//    public F read(Identity.Ego<S,L,PATH,F,N> ego) {
//
//    }


//    @Override
//    public WatchKey register(WatchService watcher, WatchEvent.Kind[] events, WatchEvent.Modifier... modifiers) throws CheckedException {
//        return null;
//    }
//
//    public <ITEM> Clerk<?,?> register(Librarian<S,L,PATH,?,?,?,?> watcher, Indicia<ITEM>[] events, Accounting... modifiers) throws CheckedException {
//        return null;
//    }
//    @Override
//    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
//        return null;
//    }
}