/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.memory.bureau.jdbc.DefaultJdbcBureauModel;
import dev.inward.matrix.control.memory.bureau.jdbc.DefaultJdbcBureauView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileStoreAttributeView;

public abstract class Memory<MC extends Memory<MC,MV,MM>,MV extends MemoryView<MC,MV,MM>,MM extends MemoryModel<MC,MV,MM>> extends FileStore implements Control<MC,MV,MM> {

    protected final String name;
    protected final boolean readOnly;
    protected final MM model;

    public Memory(String name, boolean readOnly,MM model) {
        this.name = name;
        this.readOnly = readOnly;
        this.model = model;
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
    public MM getModel() {
        return model;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        Class<MM> modelClass = (Class<MM>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        if (type.isAssignableFrom(DefaultJdbcBureauView.class)) {
            try {
                return type.getConstructor(this.getClass(), modelClass).newInstance(this,this.model);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
