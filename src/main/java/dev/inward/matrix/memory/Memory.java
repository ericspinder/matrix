/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory;

import dev.inward.matrix.*;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.addressed.AddressedResource;
import dev.inward.matrix.file.addressed.AddressedScheme;

import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;

public abstract class Memory<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends FileStore implements Comparable<Memory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> {

    protected final L library;
    protected final String name;
    protected final Range<PATH> range;
    protected final Zone zone;
    protected final DRESOURCE directoryResource;
    protected final Map<Class<?>,? extends AddressedResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,D,DM,?,?,?,?,?,?,?>>

    @SuppressWarnings("unchecked")
    public Memory(L library, String name, Range<PATH> range, Map<String,Object> attributes) {
        this.library = library;
        this.name = name;
        this.range = range;
        this.attributes = attributes;
    }
    public L getLibrary() {
        return library;
    }

    public Range<PATH> getRange() {
        return range;
    }

    @Override
    public int compareTo(Memory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM> that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public final String type() {
        return this.getClass().getCanonicalName();
    }


    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
         return type.isAssignableFrom(Ware.class);
    }

    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        return null;
    }

    @Override
    public Object getAttribute(String attribute) {
        return this.attributes.get(attribute);
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
        return name.equalsIgnoreCase("matrix");
    }


}