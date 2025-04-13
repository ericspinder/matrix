/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.container.catalog.*;
import dev.inward.matrix.container.library.*;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileView<S extends Scheme<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LK extends LibraryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,L extends Library<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LV extends LibraryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LM extends LibraryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LR extends LibraryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LG extends LibrarySteward<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,C extends Catalog<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CV extends CatalogView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CM extends CatalogModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CR extends CatalogReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CG extends CatalogSteward<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DB extends DirectoryLibrarian<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DK extends DirectoryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,D extends Directory<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DV extends DirectoryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DM extends DirectoryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DR extends DirectoryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DG extends DirectorySteward<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LB extends FileLibrarian<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG,LB,K,F,V,M,R,G>,K extends FileKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG,LB,K,F,V,M,R,G>,F extends File<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG,LB,K,F,V,M,R,G>,V extends FileView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG,LB,K,F,V,M,R,G>,M extends FileModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG,LB,K,F,V,M,R,G>,R extends FileReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG,LB,K,F,V,M,R,G>,G extends FileSteward<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG,LB,K,F,V,M,R,G>> extends DatumView<LB,F,V,M,R,G> implements BasicFileAttributeView {

    public FileView(String name, F file, M fileModel) {
        super(name, file, fileModel);
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) {
        if (lastAccessTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("lastModifiedTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.DefaultAspectType.LastModifiedTime), Model.InstanceValue.Origin.Set_byView,lastModifiedTime));
        }
        if (lastAccessTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("lastAccessTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.DefaultAspectType.LastAccessTime), Model.InstanceValue.Origin.Set_byView,lastAccessTime));
        }
        if (createTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("createTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.DefaultAspectType.CreateTime), Model.InstanceValue.Origin.Set_byView,createTime));
        }
    }
}
