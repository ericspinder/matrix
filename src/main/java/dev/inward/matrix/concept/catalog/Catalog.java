/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog;

import dev.inward.matrix.Experience;
import dev.inward.matrix.concept.fact.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.concept.item.datum.administrator.Persona;
import org.jetbrains.annotations.NotNull;

import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.time.Instant;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Catalog<CC extends Catalog<CC, CV, CM>, CV extends CatalogView<CC, CV, CM>, CM extends CatalogModel<CC, CV, CM>> extends FileStore implements Control<CC,CV,CM> {

    protected final Mount mount;
    protected final String name;
    protected final boolean readOnly;
    protected final Control<?,?,?> control;
    protected final Map<Librarian<?,?,?,?,?,?>, Instant> seenLibrarians = new WeakHashMap<>();
    protected final Map<String, Object> attributes;

    public Catalog(final Mount mount, String name, boolean readOnly, Control<?,?,?> control, Map<String,Object> attributes) {
        this.mount = mount;
        this.name = name;
        this.readOnly = readOnly;
        this.control = control;
        this.attributes = new ConcurrentHashMap<>(attributes);
    }
    public <F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> F getFile(@NotNull K key, @NotNull L librarian, @NotNull Persona persona) {
        if (this.seenLibrarians.containsKey(librarian)) {
            this.seenLibrarians.put(librarian, Instant.now());
        }
        else { this.registerUnknownLibrarian(librarian); }

        return null;
    }
    private synchronized <F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> void registerUnknownLibrarian(@NotNull L librarian) {
        if (this.seenLibrarians.containsKey(librarian)) {
            this.seenLibrarians.put(librarian,Instant.now());
        }


    }
    protected <F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> L enrollUnknownLibrarian(L librarian) {
        return librarian;
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

        return null;
    }
    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        for (Librarian<?,?,?,?,?,?> librarian : seenLibrarians.keySet()) {
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
        for (Librarian<?,?,?,?,?,?> librarian : seenLibrarians.keySet()) {
            if (librarian.getViewClass().getCanonicalName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
