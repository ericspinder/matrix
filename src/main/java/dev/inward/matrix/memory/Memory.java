/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory;

import dev.inward.matrix.Datum;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.domain.DomainReference;
import dev.inward.matrix.memory.bureau.jdbc.DefaultJdbcBureau;
import dev.inward.matrix.memory.bureau.jdbc.DefaultJdbcBureauModel;
import dev.inward.matrix.memory.bureau.jdbc.DefaultJdbcBureauView;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileStoreAttributeView;

public abstract class Memory<MD extends Memory<MD,MV,MM,MR,MB>,MV extends MemoryView<MD,MV,MM,MR,MB>,MM extends MemoryModel<MD,MV,MM,MR,MB>,MR extends MemoryReference<MD,MV,MM,MR,MB>,MB extends MemoryLibrarian<MD,MV,MM,MR,MB>> extends FileStore implements Datum<MD,MV,MM,MR,MB> {

    protected final String name;
    protected final boolean readOnly;
    protected final Domain domain;

    public Memory(Domain domain, String name, boolean readOnly) {
        this.domain = domain;
        this.name = name;
        this.readOnly = readOnly;
    }

    public Domain getDomain() {
        return domain;
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
        if (type.isAssignableFrom(DefaultJdbcBureauView.class)) {
            try {
                return type.getConstructor(MD.class, DefaultJdbcBureauModel.class).newInstance(this,this..getItemReference().getGestalt().getModel());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
