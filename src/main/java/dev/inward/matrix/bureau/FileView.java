/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.*;
import dev.inward.matrix.file.*;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileView<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,K extends FileKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,F extends File<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,R extends FileReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,A extends FileAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,RESOURCE extends FileResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>,M extends FileModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM,K,F,R,A,RESOURCE,M>> extends DatumView<F,R,A,RESOURCE,M> implements BasicFileAttributeView {

    public FileView(String name, F f) {
        super(name, f);
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    @Override
    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

    }
}
