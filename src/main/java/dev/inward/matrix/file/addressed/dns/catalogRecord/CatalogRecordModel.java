/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.dns.RRModel;

public class CatalogRecordModel<K extends CatalogRecordKey<K,F,V,M,R,B>,F extends CatalogRecord<K,F,V,M,R,B>,V extends CatalogRecordView<K,F,V,M,R,B>,M extends CatalogRecordModel<K,F,V,M,R,B>,R extends CatalogRecordReference<K,F,V,M,R,B>,B extends CatalogRecordLibrarian<K,F,V,M,R,B>> extends RRModel<K,F,V,M,R,B> {
    public CatalogRecordModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
