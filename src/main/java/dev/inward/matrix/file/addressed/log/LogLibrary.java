/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.memory.bureau.Bureau;

import java.util.Map;

public class LogLibrary extends Library<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference, LogCatalogLibrarian,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectoryLibrarian> {

    public LogLibrary(LogLibraryKey libraryKey) {
        super(libraryKey);
    }

    @Override
    protected Map<LogCatalog, Bureau<?, ?, ?, ?>[]> initCatalogs() {
        return null;
    }


//    @Override
//    protected Map<LogCatalog, Bureau<LogScheme, LogLibraryKey, LogLibrary, LogPath, LogCatalogKey, LogCatalog, LogDirectoryKey, LogDirectory, LogDirectoryReference, LogDirectoryView, LogDirectoryResource, LogDirectoryModel>[]> initCatalogs() {
//        URI uri = new URI(libraryKey.getUri() + "?startPath=*,endPath=*");
//        LogCatalogRecordParser logCatalogRecordParser = new LogCatalogRecordParser();
//        Ziggurat.getInstance().findRecords(libraryKey, logCatalogRecordParser);
//        return null;
//    }
}
