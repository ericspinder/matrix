package dev.inward.matrix;


import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.atomic.AtomicLong;

public abstract class FileAttributes<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,R,F>,FILE extends MatrixFile<PATH,K,FILE,R,F>,R extends Registar<PATH,K,FILE,R,F>,F extends FileAttributes<PATH,K,FILE,R,F>> extends DatumAttributes<FILE,R,F> implements BasicFileAttributes {

    protected final K fileKey;
    protected AtomicLong size;

    public FileAttributes(FILE file) {
        super(file);
        this.fileKey = file.getFileKey();
    }

    @Override
    public FileTime lastModifiedTime() {
        return (FileTime) this.properties.get("lastModifiedTime");
    }

    @Override
    public FileTime lastAccessTime() {
        return (FileTime) this.properties.get("lastAccessTime");
    }

    @Override
    public FileTime creationTime() {
        return (FileTime) this.properties.get("creationTime");
    }

    @Override
    public final long size() {
        return size.get();
    }

    public final AtomicLong getSize() {
        return size;
    }

    @Override
    public final K fileKey() {
        return this.fileKey;
    }
}
