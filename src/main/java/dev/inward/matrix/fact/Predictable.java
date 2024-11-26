package dev.inward.matrix.fact;

import crud.Protocol;
import crud.Volume;
import dev.inward.matrix.Provider;
import dev.inward.matrix.*;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.director.library.catalog.Ledger;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.ticket.Ticket;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Predictable<PATH extends Comparable<PATH>> implements WatchService {

    protected final Ledger<PATH> ledger;
    protected boolean open;
    public Predictable(Ledger<PATH> ledger) {
        this.ledger = ledger;
    }
    /**
     *
     * @param criterion Parameters to create the Complication
     * @param provider How the complication will retrieve the concept
     * @return the Complication that has been created
     */
    @SuppressWarnings("unchecked")
    public <W extends Watchable, C extends Complication<PATH,W,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C register(W watchable, Indicia[] indiciaArray, Criterion... criteria) throws IOException {
        if (!this.open) throw new ClosedWatchServiceException();
        for (Indicia indicia: indiciaArray) {
            try {
                Class<Provider<W>> providerClass = (Class<Provider<W>>)watchable.getClass().getClassLoader().loadClass(indicia.getComplicationClassName());
                providerClass.getDeclaredConstructor()
                Class<C> complicationClass = (Class<C>)Class.forName(indicia.getComplicationClassName());
                Constructor<C> complicationConstructor = complicationClass.getDeclaredConstructor(Provider.class, Supplier.class, Iterator.class, Boolean.class);
                C complication = complicationConstructor.

            }
            catch (ClassNotFoundException| NoSuchMethodException e) {

            }
        }
    }

    public <W extends Watchable,C extends Complication<PATH,W,C,M,?>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C poll_() {
        return null;
    }


    @Override
    public WatchKey poll() {
        return this.poll_();
    }

    @Override
    public void close() throws IOException {
        this.open = false;
    }

    @Override
    public WatchKey poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public WatchKey take() throws InterruptedException {
        return null;
    }


//    @SuppressWarnings("unchecked")
//    public Class<C> getConceptClass() {
//        return ((Class<C>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
//    }

}
