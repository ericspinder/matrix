/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.AddressedLibrarian;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.UUID;
import java.util.function.Function;

public class RRLibrarian<LB extends ResourceRecordLibrarian<LB,K,F,V,M,R,G>,K extends RRKey<LB,K,F,V,M,R,G>,F extends ResourceRecord<LB,K,F,V,M,R,G>,V extends RRView<LB,K,F,V,M,R,G>,M extends RRModel<LB,K,F,V,M,R,G>,R extends RRReference<LB,K,F,V,M,R,G>,G extends RRLibrarian<LB,K,F,V,M,R,G>> extends AddressedLibrarian<DnsScheme,DnsLibraryKey,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsLibraryReference, DnsLibraryLibrarian,DnsPath,DnsCatalogKey,DnsCatalog,DnsCatalogView,DnsCatalogModel,DnsCatalogReference, DnsCatalogLibrarian,DnsDirectoryLibrarian,DnsDirectoryKey,DnsDirectory,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference, DnsDirectoryLibrarian,LB,UUID,K,F,V,M,R,G> {

    public RRLibrarian(Function<R, R> graveDigger, R reference, Class<V> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
