/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.DepotLibrary;
import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;
import dev.inward.matrix.predictable.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.nio.file.*;
import java.util.*;

public abstract class MatrixKey<K extends MatrixKey<K,I>,I extends MatrixItem<K,I>> implements Comparable<K>, Watchable {

    protected final URI uri;
    protected MatrixKey(URI uri) {
        this.uri = uri;
    }
    public final URI getUri() {
        return this.uri;
    }

    @SuppressWarnings("unchecked")
    protected Complication<K,I> registerEvents(WatchService watcher, List<WatchEvent.Kind<?>> events, List<WatchEvent.Modifier> modifiers) throws IOException {
        Predictable predictable = (Predictable) watcher;
        if (!predictable.getDomain().getDomain().equals(this.getUri().getHost())) {
            throw new RuntimeException("MatrixKeys must be matched to correct domain and Predictable (WatchService) must be open");
        }
        Director director = predictable.getDomain().getDirector();
        String complicationClassName = null;
        ComplicationCriterion<K,I> foundComplicationCriterion = null;
        Map<Indica, PolicyCriterion<K,I,?>> policyCriteriaByIndica = new HashMap<>();
        Class<K> matrixKeyClass = (Class<K>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        for (WatchEvent.Kind<?> event: events) {
            if (event instanceof IndiciaKey indiciaKey) {
                events.remove(event);
                Indica indica = ((DepotLibrary)MatrixURLStreamHandlerProvider.findSchemeForProtocolHost(MatrixURLStreamHandlerProvider.Protocol.DEPOT, this.getUri()).findLibrary(this.getUri())).matchIndicaKey(indiciaKey.name());
                if (complicationClassName == null) {
                    complicationClassName = indica.getComplicationClassName();
                }
                else {
                    if (!indica.getComplicationClassName().equals(complicationClassName)) {
                        throw new IOException("All events configured together must match their Complication class name, " + indica + " is different than " + complicationClassName);
                    }
                }
                if (foundComplicationCriterion != null) {
                    if (indica.getComplicationCriterionClassName().equals(foundComplicationCriterion.getClassName())) {
                        throw new IOException("All events configured together must match their ComplicationCriteria class name, " + indica + " is different than " + foundComplicationCriterion.getClass().getCanonicalName());
                    }
                }
                PolicyCriterion<K,I,?> foundPolicyCriterion = null;
                for (WatchEvent.Modifier modifier : modifiers) {
                    if (foundComplicationCriterion == null && modifier instanceof ComplicationCriterion complicationCriterion) {
                        if (indica.getComplicationCriterionClassName().equals(complicationCriterion.getClassName())) {
                            foundComplicationCriterion = (ComplicationCriterion<K, I>) complicationCriterion;
                            modifiers.remove(modifier);
                        }
                    }
                    if (foundPolicyCriterion == null && modifier instanceof PolicyCriterion policyCriterion) {
                        if (indica.getPolicyCriterionClassName().equals(policyCriterion.getClassName())) {
                            foundPolicyCriterion = (PolicyCriterion<K, I,?>) policyCriterion;
                            modifiers.remove(modifier);
                        }
                    }
                }
                if (foundComplicationCriterion == null) {
                    try {
                        foundComplicationCriterion = (ComplicationCriterion<K, I>) Class.forName(indica.getComplicationClassName()).getConstructor().newInstance();
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException | InvocationTargetException e) {
                        throw new IOException("ComplicationCriterion instance of " + indica + " was not found as a passed parameter, or could not be created from a no arg constructor", e);
                    }
                }
                if (foundPolicyCriterion == null) {
                    try {
                        foundPolicyCriterion = (PolicyCriterion<K,I,?>)Class.forName(indica.getPolicyCriterionClassName()).getConstructor().newInstance();
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException | InvocationTargetException e) {
                        throw new IOException("PolicyCriterion instance of " + indica + " was not found as a passed parameter, or could not be created from no arg constructor", e);
                    }
                }
                policyCriteriaByIndica.put(indica,foundPolicyCriterion);
            }
        }
        try {
            return (Complication<K,I>)Class.forName(complicationClassName).getConstructor(Predictable.class, Director.class, matrixKeyClass, ComplicationCriterion.class, Map.class).newInstance(predictable,director, this,foundComplicationCriterion,policyCriteriaByIndica);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new IOException(e);
        }
        finally {
            StringBuilder stringBuilder = new StringBuilder();
            if (!events.isEmpty()) {
                for (WatchEvent.Kind<?> event: events) {
                    stringBuilder.append("Event not used = ").append(event.name()).append(" ,");
                }
            }
            if (!modifiers.isEmpty()) {
                for (WatchEvent.Modifier modifier: modifiers) {
                    stringBuilder.append("Modifier not used = ").append(modifier.name()).append(" ,");
                }
            }
            if (!stringBuilder.isEmpty()) {
                System.err.println(stringBuilder);
            }
        }
    }

    /**
     *
     * @param watcher
     *          the watch service to which this object is to be registered
     * @param events IndicaKeys
     *          the events for which this object should be registered
     * @param modifiers at most one ComplicationCriterion which matches all the indicas passed and a policy criterion for each of them. If any of the criterion are not found then a 'no args' constructor for the configured classes will attempt to be instantiated.
     *          the modifiers, if any, that modify how the object is registered
     *
     * @return
     * @throws IOException if the complication or a default criterion cannot be instantiated
     */
    @Override
    public Complication<K,I> register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return this.registerEvents(watcher,Arrays.asList(events),Arrays.asList(modifiers));
    }

    @Override
    public Complication<K,I> register(WatchService watcher, WatchEvent.Kind<?>[] events) throws IOException {
        return this.registerEvents(watcher,Arrays.asList(events), new ArrayList<>());
    }

    @Override
    public int compareTo(K that) {
        return this.uri.compareTo(that.uri);
    }
}
