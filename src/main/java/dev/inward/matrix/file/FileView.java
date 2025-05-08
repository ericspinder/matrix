/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public abstract class FileView<F extends File<F,K,V,M,R,L>,K extends FileKey<F,K,V,M,R,L>,V extends FileView<F,K,V,M,R,L>,M extends FileModel<F,K,V,M,R,L>,R extends FileReference<F,K,V,M,R,L>,L extends FileLibrarian<F,K,V,M,R,L>> extends DatumView<F,V,M,R,L> implements BasicFileAttributeView {

    public FileView(String name, F f) {
        super(name, f);
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) {
        if (lastAccessTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("lastModifiedTime", new Model.InstanceValue<>((this.getDatum().getContext()..getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Last_Modified_Time), Model.InstanceValue.Origin.Set_byView,lastModifiedTime));
        }
        if (lastAccessTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("lastAccessTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Last_Accessed_Time), Model.InstanceValue.Origin.Set_byView,lastAccessTime));
        }
        if (createTime != null) {
            this.getDatum().getKey().getReference().getAttributes().put("createTime", new Model.InstanceValue<>((this.getDatum().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Create_Time), Model.InstanceValue.Origin.Set_byView,createTime));
        }
    }

}
