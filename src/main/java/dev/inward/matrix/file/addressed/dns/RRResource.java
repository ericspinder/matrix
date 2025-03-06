/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.AddressedResource;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.UUID;
import java.util.function.Function;

public class RRResource<K extends RRKey<K,F,R,A,RESOURCE,M>,F extends ResourceRecord<K,F,R,A,RESOURCE,M>,R extends RRReference<K,F,R,A,RESOURCE,M>,A extends RRAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends RRResource<K,F,R,A,RESOURCE,M>,M extends RRModel<K,F,R,A,RESOURCE,M>> extends AddressedResource<DnsScheme, DnsLibraryKey,DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel,UUID,K,F,R,A,RESOURCE,M> {

    public RRResource(Function<R, R> graveDigger, M model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
