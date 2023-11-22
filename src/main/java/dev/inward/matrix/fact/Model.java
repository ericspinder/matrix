package dev.inward.matrix.fact;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.authoritative.notion.concept.Matrix;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.Named;
import dev.inward.matrix.personality.Persona;
import dev.inward.matrix.phenomenon.Phenomenon;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class Model<S extends Scheme<S,L>,L extends Library<S,L>,N extends Identity.Tangible.Named<S,L,N,F>,F extends Fact<S,L,N,F>,M extends Model<S,L,N,F,M>> extends Concept<S,L,String,String, Identity.Tangible.Id<S,L,N,F,M>,M> {

    @SuppressWarnings("unchecked")
    protected final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[3]);
    @SuppressWarnings("unchecked")
    protected final Constructor<F>[] factConstructors = (Constructor<F>[])factClass.getConstructors();
    protected final ConcurrentHashMap<Aspect<S,L,String,String,N,F>,> aspects

    public Model(Identity.Tangible.Id<S,L,N,F,M> id, Aspect<S,L,String,String,N,F>[] aspects) {
        super(id);

    }

    public boolean isCreate() {
        return create;
    }

    public F create(Identity.Ego<S,L,PATH,F,N> ego) {
        Persona persona = ego.getGetPersona();
        if (create) {
            try {
                return factConstructors[0].newInstance(ego);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public F read(Identity.Ego<S,L,PATH,F,N> ego) {

    }


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