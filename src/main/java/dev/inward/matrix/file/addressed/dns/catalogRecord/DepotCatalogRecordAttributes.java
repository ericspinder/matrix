/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.Model;

import java.util.Map;

public class DepotCatalogRecordAttributes extends CatalogRecordAttributes<DepotCatalogRecordKey, DepotCatalogRecord, DepotCatalogRecordReference, DepotCatalogRecordAttributes, DepotCatalogRecordResource, DepotCatalogRecordModel> {
    public DepotCatalogRecordAttributes(Map<String, Model.InstanceValue> properties, long fileSize) {
        super(properties, fileSize);
    }
}
