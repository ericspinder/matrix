/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.unix;

import dev.inward.matrix.memory.bureau.file.FileBureau;
import dev.inward.matrix.file.FileView;

import java.util.Map;

public abstract class UnixBureau<K extends UnixBureauKey<K,I,V,M,R,G>,I extends UnixBureau<K,I,V,M,R,G>,V extends UnixBureauView<K,I,V,M,R,G>,M extends UnixBureauModel<K,I,V,M,R,G>,R extends UnixBureauReference<K,I,V,M,R,G>,G extends UnixBureauSteward<K,I,V,M,R,G>> extends FileBureau<K,I,V,M,R,G> {
    public UnixBureau(K key, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, String rootPath) {
        super(key, attributes, supportedFileViews,rootPath);
    }

    @Override
    protected String parseRootPathForFileSystem(String rootPath) {
        if (rootPath != null && !rootPath.isEmpty()) {
            if (!rootPath.startsWith("/")) {
                throw new RuntimeException("if not empty or null, rootPath must start with / ");
            }
            return rootPath;
        }
        return "/";
    }
}
