/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;

import java.util.function.Function;

public class FileGestalt<S extends Scheme<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,LK extends LibraryKey<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,L extends Library<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,LV extends LibraryView<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,LM extends LibraryModel<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,LR extends LibraryReference<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,LS extends LibraryGestalt<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,C extends Catalog<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,CV extends CatalogView<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,CM extends CatalogModel<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,CR extends CatalogReference<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,CS extends CatalogGestalt<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,DB extends DirectoryLibrarian<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,DK extends DirectoryKey<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,D extends Directory<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,DV extends DirectoryView<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,DM extends DirectoryModel<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,DR extends DirectoryReference<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,DS extends DirectoryGestalt<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS>,LB extends FileLibrarian<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS,LB,K,F,V,M,R,S>,K extends FileKey<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS,LB,K,F,V,M,R,S>,F extends File<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS,LB,K,F,V,M,R,S>,V extends FileView<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS,LB,K,F,V,M,R,S>,M extends FileModel<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS,LB,K,F,V,M,R,S>,R extends FileReference<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS,LB,K,F,V,M,R,S>,S extends FileGestalt<S,LK,L,LV,LM,LR,LS,PATH,CK,C,CV,CM,CR,CS,DB,DK,D,DV,DM,DR,DS,LB,K,F,V,M,R,S>> extends DatumGestalt<LB,F,V,M,R,S> {

    protected final Class<V> fileViewClass;
    public FileGestalt(Function<R, R> graveDigger, M model, Class<V> fileViewClass) {
        super(graveDigger, model);
        this.fileViewClass = fileViewClass;
    }

    public Class<V> getFileViewClass() {
        return fileViewClass;
    }
}
