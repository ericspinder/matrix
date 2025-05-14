/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.AddressedLibrarian;
import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.util.UUID;
import java.util.function.Function;

public class RRLibrarian<F extends ResourceRecord<F,K,V,M,R,B>,K extends RRKey<F,K,V,M,R,B>,V extends RRView<F,K,V,M,R,B>,M extends RRModel<F,K,V,M,R,B>,R extends RRReference<F,K,V,M,R,B>,B extends RRLibrarian<F,K,V,M,R,B>> extends AddressedLibrarian<F,UUID,K,V,M,R,B,DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsPath> {

    public RRLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
