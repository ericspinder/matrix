package dev.inward.matrix;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

public abstract class FileAttributes implements BasicFileAttributes {

    protected final Properties properties;
    protected AtomicLong size;

    public FileAttributes(Properties properties) {
        this.properties = new Properties(properties);
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
    public long size() {
        return size.get();
    }

    public AtomicLong getSize() {
        return size;
    }

    @Override
    public Object fileKey() {
        return null;
    }
}
