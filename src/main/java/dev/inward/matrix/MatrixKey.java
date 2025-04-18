/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.catalog.CatalogKey;
import dev.inward.matrix.file.DirectoryKey;
import dev.inward.matrix.file.FileKey;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.addressed.depot.DepotLibrary;
import dev.inward.matrix.file.addressed.depot.indica.Indica;
import dev.inward.matrix.file.addressed.depot.indica.IndicaKey;
import dev.inward.matrix.predictable.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;

public abstract class MatrixKey<K extends MatrixKey<K,I,V,M,R,B>,I extends MatrixItem<K,I,V,M,R,B>,V extends View<I,V,M,R,B>,M extends Model<I>,R extends Reference<I,V,M,R,B>, B extends Librarian<I,V,M,R,B>> implements Path {

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

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }
    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events) throws IOException {
        return null;
    }

    @Override
    public FileSystem getFileSystem() {
        if (this instanceof FileKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> fileKey) {
            return fileKey.getCatalog();
        }
        return null;
    }

    @Override
    public boolean isAbsolute() {
        return (this instanceof FileKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>);
    }

    @Override
    public Path getRoot() {
        if (this instanceof FileKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> fileKey) {
            return fileKey.getLibrary().getKey();
        }
        return this;
    }

    @Override
    public Path getFileName() {
        if (this instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>) {
            return this;
        }
        return null;
    }

    @Override
    public Path getParent() {
        if (this instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> addressedKey) {
            return addressedKey.getDirectoryKey();
        }
        if (this instanceof DirectoryKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> directoryKey) {
            return directoryKey.getCatalog().findDirectoryPath(directoryKey.getFilePath());
        }
        if (this instanceof CatalogKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> catalogKey) {
            return catalogKey.getLibrary().getKey();
        }
        return null;
    }

    @Override
    public int getNameCount() {
        if (this instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> addressedKey) {
            return addressedKey.getDirectoryKey().getNameCount() + 1;
        }
        if (this instanceof DirectoryKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> directoryKey) {
            return directoryKey.getFilePath().toString().split("/").length;
        }
        return 0;
    }

    @Override
    public Path getName(int index) {
        return null;
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public boolean startsWith(Path other) {
        return false;
    }

    @Override
    public boolean endsWith(Path other) {
        return false;
    }

    @Override
    public Path normalize() {
        return this;
    }

    @Override
    public Path resolve(Path other) {
        return null;
    }

    @Override
    public Path relativize(Path other) {
        return null;
    }

    @Override
    public URI toUri() {
        return this.uri;
    }

    @Override
    public Path toAbsolutePath() {
        return this;
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        return this;
    }

    @Override
    public int compareTo(Path other) {
        if (other instanceof MatrixKey<?,?,?,?,?,?> that) {
            return this.uri.compareTo(that.uri);
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixKey<?,?,?,?,?,?> that = (MatrixKey<?,?,?,?,?,?>) o;
        return Objects.equals(uri.toString(), that.uri.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri);
    }

    @Override
    public String toString() {
        return this.uri.toString();
    }

    public static abstract class Builder<K extends MatrixKey<K,I,V,M,R,G>,I extends MatrixItem<K,I,V,M,R,G>,V extends View<I,M>, M extends Model<I>,R extends Reference<I,V,M,R,G>,G extends Librarian<I,V,M,R,G>> {

        protected URI uri;

        protected abstract URI makeUri() throws URISyntaxException;
        public final synchronized K buildMatrixKey() {
            try {
                this.uri = this.makeUri();
                return this.newMatrixKey();
            }
            catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        protected abstract K newMatrixKey();
    }
}
