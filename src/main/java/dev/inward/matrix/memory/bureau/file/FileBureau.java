/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file;

import dev.inward.matrix.memory.bureau.Bureau;
import dev.inward.matrix.file.FileView;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Map;


public abstract class FileBureau<K extends FileBureauKey<K,I,V,M,R,G>,I extends FileBureau<K,I,V,M,R,G>,V extends FileBureauView<K,I,V,M,R,G>,M extends FileBureauModel<K,I,V,M,R,G>,R extends FileBureauReference<K,I,V,M,R,G>,G extends FileBureauLibrarian<K,I,V,M,R,G>> extends Bureau<K,I,V,M,R,G> {

    protected final String rootPath;
    protected final FileSystem defaultFileSystem = FileSystems.getDefault();
    public FileBureau(K key, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, String rootPath) {
        super(key, attributes, supportedFileViews);
        this.rootPath = parseRootPathForFileSystem(rootPath);
    }
    protected abstract String parseRootPathForFileSystem(String rootPath);
}
