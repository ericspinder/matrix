/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;

import java.io.IOException;
import java.nio.file.attribute.FileTime;

public abstract class FileReference<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,K extends FileKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,F extends File<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,R extends FileReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,A extends FileAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,RESOURCE extends FileResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,M extends FileModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>> extends DatumReference<F,R,A,RESOURCE,M> {
    public FileReference(F referent, RESOURCE resource) {
        super(referent, resource);
    }

    public String name() {
        return this.get().getKey().toString();
    }

    public A readAttributes() throws IOException {
        return this.attributes;
    }

    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) {
        if (lastAccessTime != null) {
            this.attributes.getProperties().put("lastModifiedTime", new Model.InstanceValue(this.resource.getModel().getTypedAspects().get(Aspect.DefaultAspectType.LastModifiedTime), Model.InstanceValue.Origin.Set_byReference,lastModifiedTime));
        }
        if (lastAccessTime != null) {
            this.attributes.getProperties().put("lastAccessTime", new Model.InstanceValue(this.resource.getModel().getTypedAspects().get(Aspect.DefaultAspectType.LastAccessTime), Model.InstanceValue.Origin.Set_byReference,lastAccessTime));
        }
        if (createTime != null) {
            this.attributes.getProperties().put("createTime", new Model.InstanceValue(this.resource.getModel().getTypedAspects().get(Aspect.DefaultAspectType.CreateTime), Model.InstanceValue.Origin.Set_byReference,createTime));
        }
    }

}
