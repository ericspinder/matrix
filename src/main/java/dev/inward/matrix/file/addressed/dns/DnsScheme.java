/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.Terrene;

public class DnsScheme extends Scheme<DnsScheme,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference,DnsCatalogLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian> {

    public static final DnsScheme EARTH_SCHEME_OF_DNS = new DnsScheme(Terrene.Earth);
    public static final DnsScheme LUNA_SCHEME_OF_DNS = new DnsScheme(Terrene.Luna);
    public static final DnsScheme MARS_SCHEME_OF_DNS = new DnsScheme(Terrene.Mars);
    public static final DnsScheme CHAOSNET_SCHEME_OF_DNS = new DnsScheme(Terrene.Chaosnet);
    public DnsScheme(Terrene terrene) {
        super(terrene, MatrixURLStreamHandlerProvider.Protocol.DNS);
    }


    @Override
    public int compareTo(DnsScheme that) {
        return this.terrene.compareTo(that.terrene);
    }


}
