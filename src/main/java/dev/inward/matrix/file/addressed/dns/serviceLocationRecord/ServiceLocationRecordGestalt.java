/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serviceLocationRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRGestalt;

import java.util.function.Function;

public class ServiceLocationRecordGestalt extends RRGestalt<ServiceLocationRecordKey, ServiceLocationRecord,ServiceLocationRecordReference, ServiceLocationRecordView, ServiceLocationRecordGestalt,ServiceLocationRecordModel> {
    public ServiceLocationRecordGestalt(Function<ServiceLocationRecordReference, ServiceLocationRecordReference> graveDigger, ServiceLocationRecordModel model, Class<ServiceLocationRecordView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
