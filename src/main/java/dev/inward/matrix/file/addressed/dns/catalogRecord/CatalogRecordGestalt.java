/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRGestalt;

import java.util.function.Function;

public class CatalogRecordGestalt<K extends CatalogRecordKey<K,F,R, V,RESOURCE,M>,F extends CatalogRecord<K,F,R, V,RESOURCE,M>,R extends CatalogRecordReference<K,F,R, V,RESOURCE,M>, V extends CatalogRecordView<K,F,R, V,RESOURCE,M>,RESOURCE extends CatalogRecordGestalt<K,F,R, V,RESOURCE,M>,M extends CatalogRecordModel<K,F,R, V,RESOURCE,M>> extends RRGestalt<K, F, R, V, RESOURCE, M> {
    public CatalogRecordGestalt(Function<R, R> graveDigger, M model, Class<V> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
