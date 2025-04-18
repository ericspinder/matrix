/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.control.catalog.*;
import dev.inward.matrix.control.library.*;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileView<S extends Scheme<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,L extends Library<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LV extends LibraryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LM extends LibraryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LR extends LibraryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,LB extends LibraryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,PATH extends Comparable<PATH>,C extends Catalog<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CV extends CatalogView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CM extends CatalogModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CR extends CatalogReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,CB extends CatalogLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DK extends DirectoryKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,D extends Directory<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DV extends DirectoryView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DM extends DirectoryModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DR extends DirectoryReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,DB extends DirectoryLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB>,K extends FileKey<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,F extends File<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,V extends FileView<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,M extends FileModel<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,R extends FileReference<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>,B extends FileLibrarian<S,L,LV,LM,LR,LB,PATH,C,CV,CM,CR,CB,DK,D,DV,DM,DR,DB,K,F,V,M,R,B>> extends DatumView<F,V,M,R,B> implements BasicFileAttributeView {

    public FileView(String name, F file, R fileReference) {
        super(name, file, fileReference);
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) {
        if (lastAccessTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("lastModifiedTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Last_Modified_Time), Model.InstanceValue.Origin.Set_byView,lastModifiedTime));
        }
        if (lastAccessTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("lastAccessTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Last_Accessed_Time), Model.InstanceValue.Origin.Set_byView,lastAccessTime));
        }
        if (createTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("createTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Create_Time), Model.InstanceValue.Origin.Set_byView,createTime));
        }
    }
}
