/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.control.domain.Domain;
import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.time.Instant;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class Predictable {
    protected boolean open;
    protected final Domain domain;
    protected final Map<Complication<?,?,?,?,?,?>, Instant> complicationInstantMap = new WeakHashMap<>();
    public Predictable(Domain domain) {
        this.domain = domain;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Domain getDomain() {
        return domain;
    }

    public Director getDirector() {
        return director;
    }

    public void addFinishedComplication(Complication<?,?> finishedComplication) {
        this.finishedComplications.add(finishedComplication);
    }
//        Criterion param = extractMatchingCriterionTarget(indicia.providerClassName(),criteria);
//        try {
//            return ((Class<Provider<PATH,K>>) Class.forName(indicia.providerClassName())).getDeclaredConstructor(Watchable.class,Criterion.class).newInstance(watched,param);
//        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
    @SuppressWarnings("unchecked")
//    protected <M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> Matter.ChainSupplier<M,OCCURRENCE> createMatterChainSupplier(Domain domain, Indicia indicia, Iterator<Criterion> criteria) {
//        Criterion param = extractMatchingCriterionTarget(indicia.supplierClassName(), criteria);
//        Library_ofLog libraryOfLogLibrary = Scheme_ofLog.findLibrary()domain.getLibrary(Scheme_ofLog.);
//        try {
//            return ((Class<Matter.ChainSupplier<M,OCCURRENCE>>) Class.forName(indicia.supplierClassName())).getDeclaredConstructor(Library.class,Indicia.class,Criterion.class).newInstance(libraryOfLogLibrary,indicia,param);
//        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static Criterion extractMatchingCriterionTarget(String className, Iterator<Criterion> criteria) {
//        Criterion param = null;
//        while (criteria.hasNext()) {
//            Criterion criterion = criteria.next();
//            if (criterion.getTargetClassName().equals(className)) {
//                param = criterion;
//                if (criterion.isSingleCustomer()) {
//                    criteria.remove();
//                }
//                break;
//            }
//        }
//        return param;
//    }
//
//    @SuppressWarnings("unchecked")
//    protected static <CHAIN extends ChainSupplier<S,L,PATH,M,OCCURRENCE>,C extends Complication<S,L,PATH, K,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C a(Indicia indicia, Iterator<Criterion> criteria) {
//        Criterion criterion = extractMatchingCriterionTarget(indicia.supplierClassName(), criteria);
//        try {
//            Class<Matter.ChainSupplier<M,OCCURRENCE>> clazz = (Class<Matter.ChainSupplier<M,OCCURRENCE>>) Class.forName(indicia.supplierClassName());
//            return clazz.getDeclaredConstructor(Indicia.class,Criterion.class).newInstance(indicia,criterion);
//        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | InstantiationException |
//                 IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    public <C extends Complication<S,L,PATH, K,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C poll_() {
//        return null;
//    }


    @Override
    public Complication<?,?,?,?,?,?> poll() {
        if (!this.open) {
            throw new ClosedWatchServiceException();
        }
        return this.finishedComplications.poll();
    }

    @Override
    public void close() throws IOException {
        this.open = false;
        this.director.closeAll();
    }

    @Override
    public Complication<?,?,?,?,?,?> poll(long timeout, TimeUnit unit) throws InterruptedException {
        if (!this.open) {
            throw new ClosedWatchServiceException();
        }
        return this.finishedComplications.poll(timeout,unit);
    }

    @Override
    public Complication<?,?,?,?,?,?> take() throws InterruptedException {
        if (!this.open) {
            throw new ClosedWatchServiceException();
        }
        return this.finishedComplications.take();
    }


//    @SuppressWarnings("unchecked")
//    public Class<C> getConceptClass() {
//        return ((Class<C>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
//    }

}
