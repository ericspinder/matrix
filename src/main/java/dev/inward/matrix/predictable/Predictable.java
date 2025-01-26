package dev.inward.matrix.predictable;

import dev.inward.matrix.Provider;
import dev.inward.matrix.*;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.ChainSupplier;
import dev.inward.matrix.Library;
import dev.inward.matrix.log.Library_ofLog;
import dev.inward.matrix.log.Matter;
import dev.inward.matrix.log.Scheme_ofLog;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Predictable<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,R,F>,FILE extends MatrixFile<PATH,K,FILE,R,F>,R extends Registar<PATH,K,FILE,R,F>,F extends FileAttributes<PATH,K,FILE,R,F>> implements WatchService {
    protected boolean open;
    public Predictable() {
    }
    @SuppressWarnings("unchecked")
    protected Provider<PATH,K> createProvider(Indicia indicia, K watched, Iterator<Criterion> criteria) {
        Criterion param = extractMatchingCriterionTarget(indicia.providerClassName(),criteria);
        try {
            return ((Class<Provider<PATH,K>>) Class.forName(indicia.providerClassName())).getDeclaredConstructor(Watchable.class,Criterion.class).newInstance(watched,param);
        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    protected <M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> Matter.ChainSupplier<M,OCCURRENCE> createMatterChainSupplier(Domain domain, Indicia indicia, Iterator<Criterion> criteria) {
        Criterion param = extractMatchingCriterionTarget(indicia.supplierClassName(), criteria);
        Library_ofLog libraryOfLogLibrary = Scheme_ofLog.findLibrary()domain.getLibrary(Scheme_ofLog.);
        try {
            return ((Class<Matter.ChainSupplier<M,OCCURRENCE>>) Class.forName(indicia.supplierClassName())).getDeclaredConstructor(Library.class,Indicia.class,Criterion.class).newInstance(libraryOfLogLibrary,indicia,param);
        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Criterion extractMatchingCriterionTarget(String className, Iterator<Criterion> criteria) {
        Criterion param = null;
        while (criteria.hasNext()) {
            Criterion criterion = criteria.next();
            if (criterion.getTargetClassName().equals(className)) {
                param = criterion;
                if (criterion.isSingleCustomer()) {
                    criteria.remove();
                }
                break;
            }
        }
        return param;
    }

    @SuppressWarnings("unchecked")
    protected static <CHAIN extends ChainSupplier<S,L,PATH,M,OCCURRENCE>,C extends Complication<S,L,PATH, K,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C a(Indicia indicia, Iterator<Criterion> criteria) {
        Criterion criterion = extractMatchingCriterionTarget(indicia.supplierClassName(), criteria);
        try {
            Class<Matter.ChainSupplier<M,OCCURRENCE>> clazz = (Class<Matter.ChainSupplier<M,OCCURRENCE>>) Class.forName(indicia.supplierClassName());
            return clazz.getDeclaredConstructor(Indicia.class,Criterion.class).newInstance(indicia,criterion);
        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public <C extends Complication<PATH, K,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C register(K watched, Indicia[] indiciaArray, Criterion... criteria) throws IOException {
        if (!this.open) throw new ClosedWatchServiceException();
        List<Criterion> criterionList = Arrays.stream(criteria).toList();
        for (Indicia indicia: indiciaArray) {
            Provider<PATH,K> providerClass = this.createProvider(indicia,watched,criterionList.iterator());
            Matter.ChainSupplier<M,OCCURRENCE> chainSupplier = createMatterChainSupplier(watched.getDomain(),criterionList.iterator());
            C complication = CreateComplication()
            try {

                providerClass.getDeclaredConstructor(Watchable.class).newInstance(watchable);
                Class<C> complicationClass = (Class<C>)Class.forName(indicia.complicationClassName());
                Constructor<C> complicationConstructor = complicationClass.getDeclaredConstructor(Provider.class, Supplier.class, Iterator.class, Boolean.class);
                C complication = complicationConstructor.

            }
            catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                   InvocationTargetException e) {

            }
        }
    }

    public <C extends Complication<S,L,PATH, K,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C poll_() {
        return null;
    }


    @Override
    public Complication poll() {
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
