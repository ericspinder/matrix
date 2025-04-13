/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.Model;
import dev.inward.matrix.file.DirectoryView;

import java.util.Map;

public class LogDirectoryView extends DirectoryView<LogScheme,LogLibraryKey,LogLibrary,LogPath,LogCatalogKey,LogCatalog,LogDirectoryKey,LogDirectory,LogDirectoryReference, LogDirectoryView,LogDirectoryResource,LogDirectoryModel> {
    public LogDirectoryView(Map<String, Model.InstanceValue> properties) {
        super(properties);
    }
}
