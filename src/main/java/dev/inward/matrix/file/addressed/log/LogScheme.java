/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.log;

import dev.inward.matrix.container.domain.Domain;
import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

public class LogScheme extends Scheme<LogScheme,LogLibraryKey,LogLibrary,LogLibraryView,LogLibraryModel,LogLibraryReference, LogLibrarySteward,LogPath,LogCatalogKey,LogCatalog,LogCatalogView,LogCatalogModel,LogCatalogReference, LogCatalogSteward,LogDirectoryLibrarian,LogDirectoryKey,LogDirectory,LogDirectoryView,LogDirectoryModel,LogDirectoryReference, LogDirectorySteward> {

    public static final LogScheme EARTH_SCHEME_OF_LOG = new LogScheme(Terrene.Earth);
    public static final LogScheme TERRENE_SCHEME_OF_LOG = new LogScheme(Terrene.Luna);
    public static final LogScheme MARS_SCHEME_OF_LOG = new LogScheme(Terrene.Mars);
    public static final LogScheme CHAOSNET_SCHEME_OF_LOG = new LogScheme(Terrene.Chaosnet);
    public static final LogScheme HELIOS_SCHEME_OF_LOG = new LogScheme(Terrene.Helios);
    protected LogScheme(Terrene terrene) {
        super(terrene, MatrixURLStreamHandlerProvider.Protocol.LOG);
    }


    @Override
    protected LogLibraryKey makeLibraryKey(LogScheme scheme, Domain domain, int port, String separator) {
        return null;
    }

    @Override
    protected LogLibrary buildLibrary(LogLibraryKey libraryKey) {
        return null;
    }
}
