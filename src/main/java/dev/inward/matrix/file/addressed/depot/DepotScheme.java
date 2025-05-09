/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot;

import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.Terrene;

public class DepotScheme extends Scheme<DepotScheme,DepotLibrary,DepotLibraryView,DepotLibraryModel,DepotLibraryReference, DepotLibraryLibrarian,DepotPath,DepotCatalog,DepotCatalogView,DepotCatalogModel,DepotCatalogReference,DepotCatalogLibrarian,DepotDirectoryKey,DepotDirectory,DepotDirectoryView,DepotDirectoryModel,DepotDirectoryReference,DepotDirectoryLibrarian> {

    public static final DepotScheme EARTH_SCHEME_OF_CODE = new DepotScheme(Terrene.Earth);
    public static final DepotScheme LUNA_SCHEME_OF_CODE = new DepotScheme(Terrene.Luna);
    public static final DepotScheme MARS_SCHEME_OF_CODE = new DepotScheme(Terrene.Mars);
    public static final DepotScheme CHAOSNET_SCHEME_OF_CODE = new DepotScheme(Terrene.Chaosnet);
    public static final DepotScheme HELIOS_SCHEME_OF_CODE = new DepotScheme(Terrene.Helios);

    protected DepotScheme(Terrene terrene) {
        super(terrene, MatrixURLStreamHandlerProvider.Protocol.DEPOT);
    }


    @Override
    public int compareTo(DepotScheme o) {
        return 0;
    }

}
