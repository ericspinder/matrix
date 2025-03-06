/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.*;
import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.AddressedScheme;

public class DnsScheme extends Scheme<DnsScheme,DnsLibraryKey,DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel> {

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


    @Override
    protected DnsLibraryKey makeLibraryKey(DnsScheme scheme, Domain domain, int port, String separator) {
        return null;
    }

    @Override
    protected DnsLibrary buildLibrary(DnsLibraryKey libraryKey) {
        return null;
    }
}
