/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file;

import dev.inward.matrix.memory.bureau.Bureau;
import dev.inward.matrix.file.FileView;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Map;


public abstract class FileBureau<BD extends FileBureau<BD,BV,BM,BR,BB>,BV extends FileBureauView<BD,BV,BM,BR,BB>,BM extends FileBureauModel<BD,BV,BM,BR,BB>,BR extends FileBureauReference<BD,BV,BM,BR,BB>,BB extends FileBureauLibrarian<BD,BV,BM,BR,BB>> extends Bureau<BD,BV,BM,BR,BB> {

    protected final String rootPath;
    protected final FileSystem defaultFileSystem = FileSystems.getDefault();

    public FileBureau(Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews, String rootPath) {
        super(attributes, supportedFileViews);
        this.rootPath = rootPath;
    }

    protected abstract String parseRootPathForFileSystem(String rootPath);
}
