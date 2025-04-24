/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.memory.bureau.Bureau;

import java.util.Map;

public class LogLibrary extends Library<LogScheme,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibraryLibrarian,LogPath,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference,LogCatalogLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference,LogDirectoryLibrarian> {
    public LogLibrary(LogScheme scheme, Domain domain, int port, String separator) {
        super(scheme, domain, port, separator);
    }

    @Override
    protected Map<LogCatalog, Bureau<?, ?, ?, ?, ?, ?, ?>[]> initCatalogs() {
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
