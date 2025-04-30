/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau;

import dev.inward.matrix.*;
import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.file.*;
import dev.inward.matrix.file.addressed.info.Persona;
import dev.inward.matrix.memory.Memory;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Bureau<BD extends Bureau<BD,BV,BM,BR,BB>,BV extends BureauView<BD,BV,BM,BR,BB>,BM extends BureauModel<BD,BV,BM,BR,BB>,BR extends BureauReference<BD,BV,BM,BR,BB>,BB extends BureauLibrarian<BD,BV,BM,BR,BB>> extends Memory<BD,BV,BM,BR,BB> {


    protected final Class<FileView<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>>[] supportedFileViews;

    protected final Map<String, Object> attributes;

    @SuppressWarnings("unchecked")
    public Bureau(Domain domain, String name, boolean readOnly, Map<String,Object> attributes, Class<FileView<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>>[] supportedFileViews) {
        super(domain, name, readOnly);
        this.attributes = new ConcurrentHashMap<>(attributes);
        this.supportedFileViews = supportedFileViews;
    }

    public abstract <S extends Scheme<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,L extends Library<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LV extends LibraryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LM extends LibraryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LR extends LibraryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LB extends LibraryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,PATH extends Comparable<PATH>,C extends Catalog<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CV extends CatalogView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CM extends CatalogModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CR extends CatalogReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CB extends CatalogLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DK extends DirectoryKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,D extends Directory<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DV extends DirectoryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DM extends DirectoryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DR extends DirectoryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DB extends DirectoryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,K extends FileKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,F extends File<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,V extends FileView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,M extends FileModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,R extends FileReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,B extends FileLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>> F getFile(K key, R reference, Persona persona);


    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        for (Class<FileView<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> fileViewClass: supportedFileViews) {
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
        for (Class<FileView<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> fileViewClass: supportedFileViews) {
            if (fileViewClass.isAssignableFrom(FileView.class) && (fileViewClass.getSimpleName().equals(name) || fileViewClass.getCanonicalName().equals(name))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long getTotalSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUsableSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUnallocatedSpace() throws IOException {
        return 0;
    }

}