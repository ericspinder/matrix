/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.file.DirectoryGestalt;

import java.util.function.Function;

public class LogDirectoryGestalt extends DirectoryGestalt<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectoryGestalt> {
    public LogDirectoryGestalt(Function<LogDirectoryReference, LogDirectoryReference> graveDigger, LogDirectoryModel model, Class<LogDirectoryView> viewClass) {
        super(graveDigger, model,viewClass);
    }
}
