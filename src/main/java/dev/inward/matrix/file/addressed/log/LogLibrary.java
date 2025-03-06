/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.Library;
import dev.inward.matrix.Ziggurat;
import dev.inward.matrix.file.addressed.AddressedLibrary;
import dev.inward.matrix.file.addressed.dns.catalogRecord.LogCatalogRecordParser;
import dev.inward.matrix.memory.Memory;

import java.net.URI;
import java.util.Map;

public class LogLibrary extends Library<LogScheme,LogLibraryKey,LogLibrary,LogPath,LogCatalogKey,LogCatalog,LogDirectoryKey,LogDirectory,LogDirectoryReference,LogDirectoryAttributes,LogDirectoryResource,LogDirectoryModel> {

    public LogLibrary(LogLibraryKey libraryKey) {
        super(libraryKey);
    }

    @Override
    protected Map<LogCatalog, Memory<LogScheme, LogLibraryKey, LogLibrary, LogPath, LogCatalogKey, LogCatalog, LogDirectoryKey, LogDirectory, LogDirectoryReference, LogDirectoryAttributes, LogDirectoryResource, LogDirectoryModel>[]> initCatalogs() {
        URI uri = new URI(libraryKey.getUri() + "?startPath=*,endPath=*");
        LogCatalogRecordParser logCatalogRecordParser = new LogCatalogRecordParser();
        Ziggurat.getInstance().findRecords(libraryKey, logCatalogRecordParser);
        return null;
    }
}
