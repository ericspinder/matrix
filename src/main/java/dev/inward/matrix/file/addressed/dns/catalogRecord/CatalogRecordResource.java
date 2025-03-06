/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRResource;

import java.util.function.Function;

public class CatalogRecordResource<K extends CatalogRecordKey<K,F,R,A,RESOURCE,M>,F extends CatalogRecord<K,F,R,A,RESOURCE,M>,R extends CatalogRecordReference<K,F,R,A,RESOURCE,M>,A extends CatalogRecordAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends CatalogRecordResource<K,F,R,A,RESOURCE,M>,M extends CatalogRecordModel<K,F,R,A,RESOURCE,M>> extends RRResource<K, F, R, A, RESOURCE, M> {
    public CatalogRecordResource(Function<R, R> graveDigger, M model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
