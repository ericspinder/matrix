/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.*;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;

public abstract class Bureau<B extends Bureau<B,C>,C extends Clerk<B,C>> extends FileStore implements Comparable<Bureau<B,C>> {

    protected final String name;
    protected final Class<FileView<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>>[] supportedFileViews;

    @SuppressWarnings("unchecked")
    public Bureau(String name, Class<FileStoreView> fileStoreViewClass, Class<FileView<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>>... supportedFileViews) {
        this.name = name;
        this.supportedFileViews = supportedFileViews;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public final String type() {
        return this.getClass().getCanonicalName();
    }

    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
         for (Class<FileView<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> fileViewClass: supportedFileViews) {
             if (type.isAssignableFrom(fileViewClass)) {
                 return true;
             }
         }
         return false;
    }

    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        return null;
    }

    @Override
    public Object getAttribute(String attribute) {
        return this.attributes.get(attribute);
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
        return name.equalsIgnoreCase("matrix");
    }

    @Override
    public int compareTo(Bureau<B, C> that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public long getTotalSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUsableSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUnallocatedSpace() throws IOException {
        return 0;
    }

    public static class Jdbc extends Bureau<Jdbc,Clerk.Jdbc> {

        public Jdbc(String name) {
            super(name);
        }

    }
    public static class File extends Bureau<File,Clerk.File> {

        public File(String name, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>... supportedFileViews) {
            super(name, supportedFileViews);
        }
    }
    public abstract static class Network<B extends Bureau.Network<B,C,H,S>,C extends Clerk.Network<B,C,H,S>,H extends Host<S>,S extends SocketAddress> extends Bureau<B,C> {

        public Network(String name) {
            super(name);
        }

        public static class NioServer extends Network<NioServer,Clerk.Network.NioServer,Host.LocalHost, SocketAddress.LocalHost> {

            public NioServer(String name) {
                super(name);
            }
        }
        public static class NioClient extends Network<NioClient,Clerk.Network.NioClient,Host.Remote,SocketAddress.Remote> {

            public NioClient(String name) {
                super(name);
            }
        }
    }


}