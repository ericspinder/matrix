/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.AddressedGestalt;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.UUID;
import java.util.function.Function;

public class RRGestalt<K extends RRKey<K,F,R,A,RESOURCE,M>,F extends ResourceRecord<K,F,R,A,RESOURCE,M>,R extends RRReference<K,F,R,A,RESOURCE,M>,A extends RRView<K,F,R,A,RESOURCE,M>,RESOURCE extends RRGestalt<K,F,R,A,RESOURCE,M>,M extends RRModel<K,F,R,A,RESOURCE,M>> extends AddressedGestalt<DnsScheme, DnsLibraryKey,DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference, DnsDirectoryView, DnsDirectoryGestalt,DnsDirectoryModel,UUID,K,F,R,A,RESOURCE,M> {

    public RRGestalt(Function<R, R> graveDigger, M model, Class<A> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
