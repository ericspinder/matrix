/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.Addressed;

import java.util.UUID;

public abstract class ResourceRecord<K extends RRKey<K,F,V,M,R,B>,F extends ResourceRecord<K,F,V,M,R,B>,V extends RRView<K,F,V,M,R,B>,M extends RRModel<K,F,V,M,R,B>,R extends RRReference<K,F,V,M,R,B>,B extends RRLibrarian<K,F,V,M,R,B>> extends Addressed<DnsScheme,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference,DnsCatalogLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian,UUID,K,F,V,M,R,B> {

    protected int ttl;

    public ResourceRecord(K key,int ttl) {
        super(key);
        this.ttl = ttl;
    }


}
