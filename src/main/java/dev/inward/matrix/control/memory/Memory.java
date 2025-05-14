/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.memory.bureau.jdbc.DefaultJdbcBureauModel;
import dev.inward.matrix.control.memory.bureau.jdbc.DefaultJdbcBureauView;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.user.Persona;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Memory<MC extends Memory<MC,MV,MM>,MV extends MemoryView<MC,MV,MM>,MM extends MemoryModel<MC,MV,MM>> extends FileStore implements Control<MC,MV,MM> {

    protected final String name;
    protected final boolean readOnly;
    protected final Class<FileView<?,?,?,?,?,?>>[] supportedFileViews;

    protected final Map<String, Object> attributes;

    public Memory(String name, boolean readOnly,Map<String,Object> attributes, Class<FileView<?,?,?,?,?,?>>[] supportedFileViews) {
        this.name = name;
        this.readOnly = readOnly;
        this.attributes = new ConcurrentHashMap<>(attributes);
        this.supportedFileViews = supportedFileViews;
    }
    public abstract <F extends File<F,K,V,M,R,L>,K extends FileKey<F,K,V,M,R,L>,V extends FileView<F,K,V,M,R,L>,M extends FileModel<F,K,V,M,R,L>,R extends FileReference<F,K,V,M,R,L>,L extends FileLibrarian<F,K,V,M,R,L>> F getFile(K key, Persona persona);

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
        if (type.isAssignableFrom(DefaultJdbcBureauView.class)) {
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
        for (Class<FileView<?,?,?,?,?,?>> fileViewClass: supportedFileViews) {
            if (type.isAssignableFrom(fileViewClass)) {
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
        for (Class<FileView<?,?,?,?,?,?>> fileViewClass: supportedFileViews) {
            if (fileViewClass.isAssignableFrom(FileView.class) && (fileViewClass.getSimpleName().equals(name) || fileViewClass.getCanonicalName().equals(name))) {
                return true;
            }
        }
        return false;
    }

}
