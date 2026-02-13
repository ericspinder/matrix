/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.predictable;

import dev.inward.matrix.Model;
import dev.inward.matrix.View;
import dev.inward.matrix.item.materilized.administrator.agent.Agent;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.Watchable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class Chit<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>> implements WatchKey {

    protected boolean open = true;
    protected final Agent<?,?,?> agent;
    protected final Map<Complication<TARGET,V,M,?>, Instant> complicationInstantMap = new WeakHashMap<>();
    protected final Reference<TARGET> targetReference;

    public Chit(Agent<?,?,?> agent, TARGET target) {
        this.agent = agent;
        this.targetReference = new WeakReference<>(target);
    }

    public Chit(Agent<?,?,?> agent, Reference<TARGET> targetReference) {
        this.agent = agent;
        this.targetReference = targetReference;

    }

    public boolean isOpen() {
        return open;
    }

    protected final void setOpen(boolean open) {
        this.open = open;
    }

    public Agent<?, ?, ?> getAgent() {
        return agent;
    }

    public Map<Complication<TARGET,V,M,?>, Instant> getComplicationInstantMap() {
        return complicationInstantMap;
    }
    public void addComplication(Complication<TARGET,V,M,?> complication) {
        this.complicationInstantMap.put(complication, Instant.now());
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public List<WatchEvent<?>> pollEvents() {
        List<WatchEvent<?>> events = new ArrayList<>();
        TARGET target = targetReference.get();
        if (target == null) {
            cancel();
            return List.of();
        }
        for (Complication<?,?,?,?> complication: complicationInstantMap.keySet()) {

            events.add(complication.pollEvents(target));
        }
        return events
    }

    @Override
    public boolean reset() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public Watchable watchable() {
        return null;
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
//    protected <M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> Matter.ChainSupplier<M,OCCURRENCE> createMatterChainSupplier(Domain domainName, Indicia indicia, Iterator<Criterion> criteria) {
//        Criterion param = extractMatchingCriterionTarget(indicia.supplierClassName(), criteria);
//        Library_ofLog libraryOfLogLibrary = Scheme_ofLog.findLibrary()domainName.getLibrary(Scheme_ofLog.);
//        try {
//            return ((Class<Matter.ChainSupplier<M,OCCURRENCE>>) Class.forName(indicia.supplierClassName())).getDeclaredConstructor(Library.class,Indicia.class,Criterion.class).newInstance(libraryOfLogLibrary,indicia,param);
//        } catch (ClassNotFoundException | ClassCastException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static Criterion extractMatchingCriterionTarget(String className, Iterator<Criterion> criteria) {
//        Criterion param = null;
//        while (criteria.hasNext()) {W
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



//    @SuppressWarnings("unchecked")
//    public Class<C> getConceptClass() {
//        return ((Class<C>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
//    }

}
