/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.platform.unix;

import dev.inward.matrix.catalog.platform.PlatformBureau;
import dev.inward.matrix.file.FileView;

import java.util.Map;

public abstract class UnixBureau<BC extends UnixBureau<BC,BV,BM>,BV extends UnixBureauView<BC,BV,BM>,BM extends UnixBureauModel<BC,BV,BM>> extends PlatformBureau<BC,BV,BM> {
    public UnixBureau(String name, boolean readOnly,BM unixBureauModel, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, String rootPath) {
        super(name,readOnly,unixBureauModel, attributes, supportedFileViews,rootPath);
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
