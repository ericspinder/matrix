/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.library.CatalogKey;
import dev.inward.matrix.file.addressed.depot.DepotLibrary;
import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.file.addressed.depot.indica.IndicaKey;
import dev.inward.matrix.predictable.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.nio.file.*;
import java.util.*;

public abstract class MatrixKey<K extends MatrixKey<K,I,V,M,R,B>,I extends MatrixItem<K,I,V,M,R,B>,V extends View<I,V,M,R,B>,M extends Model<I>,R extends _WeakReference<I,V,M,R,B>, B extends Concept<I,V,M,R,B>> implements Path {

    protected final URI uri;
    protected R itemReference;

    protected MatrixKey(URI uri) {
        this.uri = uri;
    }

    public R getItemReference() {
        return this.itemReference;
    }
    public void setItemReference(R itemReference) {
        if (this.itemReference == null) {
            this.itemReference = itemReference;
        }
    }

    @SuppressWarnings("unchecked")
    protected void registerEvents(List<EventTarget> events, List<Criterion> modifiers) throws IOException {

        Director director = predictable.getDomain().getDirector();
        Map<Indica, Criterion<K,I,V,M>> policyCriteriaByIndica = new HashMap<>();
        Class<K> matrixKeyClass = (Class<K>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        for (WatchEvent.Kind<?> event: events) {
            if (event instanceof IndicaKey indicaKey) {
                events.remove(event);
                Indica indica = ((DepotLibrary)MatrixURLStreamHandlerProvider.findSchemeForProtocolHost(MatrixURLStreamHandlerProvider.Protocol.DEPOT, this.uri).findLibrary(this.toUri())).matchIndicaKey(indicaKey.name());
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
                PolicyCriterion<PATH,K,I,?> foundPolicyCriterion = null;
                for (WatchEvent.Modifier modifier : modifiers) {
                    if (foundComplicationCriterion == null && modifier instanceof ComplicationCriterion complicationCriterion) {
                        if (indica.getComplicationCriterionClassName().equals(complicationCriterion.getClassName())) {
                            foundComplicationCriterion = (ComplicationCriterion<PATH,K, I>) complicationCriterion;
                            modifiers.remove(modifier);
                        }
                    }
                    if (foundPolicyCriterion == null && modifier instanceof PolicyCriterion policyCriterion) {
                        if (indica.getPolicyCriterionClassName().equals(policyCriterion.getClassName())) {
                            foundPolicyCriterion = (PolicyCriterion<PATH,K, I,?>) policyCriterion;
                            modifiers.remove(modifier);
                        }
                    }
                }
                if (foundComplicationCriterion == null) {
                    try {
                        foundComplicationCriterion = (ComplicationCriterion<PATH,K, I>) Class.forName(indica.getComplicationClassName()).getConstructor().newInstance();
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException | InvocationTargetException e) {
                        throw new IOException("ComplicationCriterion instance of " + indica + " was not found as a passed parameter, or could not be created from a no arg constructor", e);
                    }
                }
                if (foundPolicyCriterion == null) {
                    try {
                        foundPolicyCriterion = (PolicyCriterion<PATH,K,I,?>)Class.forName(indica.getPolicyCriterionClassName()).getConstructor().newInstance();
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException | InvocationTargetException e) {
                        throw new IOException("PolicyCriterion instance of " + indica + " was not found as a passed parameter, or could not be created from no arg constructor", e);
                    }
                }
                policyCriteriaByIndica.put(indica,foundPolicyCriterion);
            }
        }
        try {
            return (Complication<PATH,K,I>)Class.forName(complicationClassName).getConstructor(Predictable.class, Director.class, matrixKeyClass, ComplicationCriterion.class, Map.class).newInstance(predictable,director, this,foundComplicationCriterion,policyCriteriaByIndica);
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


}
