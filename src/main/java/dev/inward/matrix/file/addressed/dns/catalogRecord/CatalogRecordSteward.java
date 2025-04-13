/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRSteward;

import java.util.function.Function;

public class CatalogRecordSteward<LB extends CatalogRecordLibrarian<LB,K,F,V,M,R,G>,K extends CatalogRecordKey<LB,K,F,V,M,R,G>,F extends CatalogRecord<LB,K,F,V,M,R,G>,V extends CatalogRecordView<LB,K,F,V,M,R,G>,M extends CatalogRecordModel<LB,K,F,V,M,R,G>,R extends CatalogRecordReference<LB,K,F,V,M,R,G>,G extends CatalogRecordSteward<LB,K,F,V,M,R,G>> extends RRSteward<LB,K,F,V,M,R,G> {
    public CatalogRecordSteward(Function<R, R> graveDigger, R reference, Class<V> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
