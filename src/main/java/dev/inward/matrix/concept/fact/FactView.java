/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact;

import dev.inward.matrix.*;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public abstract class FactView<F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends Context<?, ?, ?, ?>> extends View<F,V,M> implements BasicFileAttributeView {

    public FactView(String name, F f) {
        super(name, f);
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) {
        if (lastAccessTime != null) {
            //this.getTarget().getKey().getReference().getAttributes().put("lastModifiedTime", new Model.InstanceValue<>((this.getTarget().getContext()..getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Last_Modified_Time), Model.InstanceValue.Origin.Set_byView,lastModifiedTime));
        }
        if (lastAccessTime != null) {
            //this.getTarget().getKey().getReference().getAttributes().put("lastAccessTime", new Model.InstanceValue<>((this.getTarget().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Last_Accessed_Time), Model.InstanceValue.Origin.Set_byView,lastAccessTime));
        }
        if (createTime != null) {
            //this.getTarget().getKey().getReference().getAttributes().put("createTime", new Model.InstanceValue<>((this.getTarget().getKey().getLibrary().getClassNameResourceMap().get(this.getClass().getCanonicalName())).getModel().getTypedAspects().get(Aspect.AspectType.ObjectAspectType.Create_Time), Model.InstanceValue.Origin.Set_byView,createTime));
        }
    }

}
