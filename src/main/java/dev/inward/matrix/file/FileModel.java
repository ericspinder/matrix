/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.*;

import java.io.IOException;
import java.nio.file.attribute.*;
import java.util.List;

public class FileModel<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,K extends FileKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,F extends File<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,R extends FileReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,A extends FileAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,RESOURCE extends FileResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,M extends FileModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>> extends DatumModel<F,R,A,RESOURCE,M> implements AclFileAttributeView, BasicFileAttributeView {

    public FileModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }

    @Override
    public List<AclEntry> getAcl() throws IOException {
        return null;
    }

    @Override
    public void setAcl(List<AclEntry> acl) throws IOException {

    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    @Override
    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

    }

    @Override
    public UserPrincipal getOwner() throws IOException {
        return null;
    }

    @Override
    public void setOwner(UserPrincipal owner) throws IOException {

    }

    @Override
    public String name() {
        return null;
    }
}
