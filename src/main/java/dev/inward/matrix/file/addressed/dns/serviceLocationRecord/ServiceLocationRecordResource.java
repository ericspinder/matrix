/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serviceLocationRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRResource;

import java.util.function.Function;

public class ServiceLocationRecordResource extends RRResource<ServiceLocationRecordKey, ServiceLocationRecord,ServiceLocationRecordReference,ServiceLocationRecordAttributes,ServiceLocationRecordResource,ServiceLocationRecordModel> {
    public ServiceLocationRecordResource(Function<ServiceLocationRecordReference, ServiceLocationRecordReference> graveDigger, ServiceLocationRecordModel model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
