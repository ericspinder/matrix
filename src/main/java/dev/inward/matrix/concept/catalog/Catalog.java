/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog;

import dev.inward.matrix.Context;
import dev.inward.matrix.Experience;
import dev.inward.matrix.Seat;
import dev.inward.matrix.concept.ConceptExperience;
import dev.inward.matrix.concept.fact.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.concept.catalog.jdbc.DefaultJdbcCatalogView;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.concept.item.datum.administrator.Persona;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Catalog<CC extends Catalog<CC, CV, CM>, CV extends CatalogView<CC, CV, CM>, CM extends CatalogModel<CC, CV, CM>> extends FileStore {

    protected final Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library;
    protected final Mount mount;
    protected final String name;
    protected final boolean readOnly;
    protected final Control<?,?,?> control;
    protected final Map<Librarian<?, ?, ?, ?, ?, ?, ?>, CatalogExperience<?, ?, ?, ?, ?, ?>> seenLibrarians = new WeakHashMap<>();
    protected final Map<Librarian<?, ?, ?, ?, ?, ?, ?>, Librarian<?, ?, ?, ?, ?, ?, ?>> librarians = new ConcurrentHashMap<>();
    protected final Map<String, Object> attributes;

    public Catalog(Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> library, final Mount mount, String name, boolean readOnly, Control<?,?,?> control, Map<String,Object> attributes) {
        this.library = library;
        this.mount = mount;
        this.name = name;
        this.readOnly = readOnly;
        this.control = control;
        this.attributes = new ConcurrentHashMap<>(attributes);
    }
    public <F extends Fact<F,K,V,M,R,L,C>,K extends FactKey<F,K,V,M,R,L,C>,V extends FactView<F,K,V,M,R,L,C>,M extends FactModel<F,K,V,M,R,L,C>,R extends Seat<F>,L extends Librarian<F,K,V,M,R,L,C>,C extends Context<F,K,V,M,R,L,C>> F getFile(K key, L librarian, Persona persona) {
        if (librarian != null && this.librarians.containsKey(librarian)) {
            synchronized (librarians.get(librarian)) {
                if (this.librarians.get(librarian).equals(librarian)) {

                }
            }
        }
        return null;
    }
    public final Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getLibrary() {
        return library;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String type() {
        return this.getClass().getCanonicalName();
    }

    @Override
    public boolean isReadOnly() {
        return readOnly;
    }

    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        if (type.isAssignableFrom(DefaultJdbcCatalogView.class)) {
            try {
                return type.getConstructor(this.getClass()).newInstance(this);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        for (Librarian<?,?,?,?,?,?,?> librarian : librarians) {
            if (type.isAssignableFrom(librarian.getViewClass())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getAttribute(String attribute) {
        if (!this.attributes.containsKey(attribute)) {

        }
        return this.attributes.get(attribute);
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
        for (Librarian<?,?,?,?,?,?> librarian : librarians) {
            if (librarian.getViewClass().getCanonicalName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public class Audit<V extends FileStoreAttributeView> implements FileStoreAttributeView {
    }

    public class TimeClock<V extends FileStoreAttributeView> implements FileStoreAttributeView {}
    public class CatalogExperience<CC extends Catalog<CC, CV, CM>, CV extends CatalogView<CC, CV, CM>, CM extends CatalogModel<CC, CV, CM>> extends Experience<CC,CV,CM> {

    }
}
