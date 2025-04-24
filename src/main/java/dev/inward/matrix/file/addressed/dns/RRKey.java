/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.AddressedKey;

import java.net.URI;
import java.util.UUID;

public class RRKey<K extends RRKey<K,F,V,M,R,B>,F extends ResourceRecord<K,F,V,M,R,B>,V extends RRView<K,F,V,M,R,B>,M extends RRModel<K,F,V,M,R,B>,R extends RRReference<K,F,V,M,R,B>,B extends RRLibrarian<K,F,V,M,R,B>> extends AddressedKey<DnsScheme,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference,DnsCatalogLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian,UUID,K,F,V,M,R,B> {

    protected final boolean randomUUID;
    protected RRKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey, boolean randomUUID) {
        super(uri, uuid, directoryKey);
        this.randomUUID = randomUUID;
    }

    public boolean isRandomUUID() {
        return randomUUID;
    }

    public static abstract class Builder<K extends RRKey<K,F,V,M,R,B>,F extends ResourceRecord<K,F,V,M,R,B>,V extends RRView<K,F,V,M,R,B>,M extends RRModel<K,F,V,M,R,B>,R extends RRReference<K,F,V,M,R,B>,B extends RRLibrarian<K,F,V,M,R,B>> extends AddressedKey.Builder<DnsScheme,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference,DnsCatalogLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian,UUID,K,F,V,M,R,B> {

        protected boolean randomUUID;

        public Builder<K,F,V,M,R,B> setRandomUUID(boolean isRandomUUID) {
            this.randomUUID = isRandomUUID;
            return this;
        }
    }

}
