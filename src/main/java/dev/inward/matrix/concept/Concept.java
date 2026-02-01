/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept;

import dev.inward.matrix.*;
import dev.inward.matrix.item.datum.standard.Standard;
import dev.inward.matrix.control.library.Library;

import java.lang.ref.Reference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.security.PermissionCollection;

public abstract class Concept<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET,V,M>,C extends Concept<TARGET,V,M,C,X>,X extends Context<TARGET,V,M,C,X>> extends PermissionCollection {

    //protected final Map<Action.ActionType, Action[]> restraints;
    protected final M model;
    protected final Class<V> viewClass;
    protected final Class<? extends Bus<TARGET,V,M,S,>>

    public Concept(Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library, Standard standard) {;
        try {
            this.viewClass = createViewClass();
            this.referenceClass = assignReferenceClass(standard);
            this.model = createModelInstance(library, standard);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    protected Class<V> createViewClass() {
        return (Class<V>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    @SuppressWarnings("unchecked")
    protected Class<? extends Reference<TARGET>> assignReferenceClass(Standard standard) throws ClassNotFoundException {
        return (Class<? extends Reference<TARGET>>) Class.forName(standard.getReferenceClassName());
    }

    @SuppressWarnings("unchecked")
    protected M createModelInstance(Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library, Standard standard) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return ((Class<M>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]).getConstructor(Library.class, Standard.class).newInstance(library,standard);
    }
    public M getModel() {
        return this.model;
    }
    public Class<? extends Reference<TARGET>> getReferenceClass() {
        return referenceClass;
    }

    public Class<V> getViewClass() {
        return viewClass;
    }
}
