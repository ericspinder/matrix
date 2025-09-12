/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.bureau.platform;

import dev.inward.matrix.catalog.bureau.Bureau;
import dev.inward.matrix.file.FileView;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Map;


public abstract class PlatformBureau<BC extends PlatformBureau<BC,BV,BM>,BV extends PlatformBureauView<BC,BV,BM>,BM extends PlatformBureauModel<BC,BV,BM>> extends Bureau<BC,BV,BM> {

    protected final String rootPath;
    protected final FileSystem defaultFileSystem = FileSystems.getDefault();

    public PlatformBureau(String name, boolean readOnly, BM fileBureauModel, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, String rootPath) {
        super(name, readOnly,fileBureauModel,attributes, supportedFileViews);
        this.rootPath = rootPath;
    }

    protected abstract String parseRootPathForFileSystem(String rootPath);
}
