/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.serviceLocationRecord;

import dev.inward.matrix.file.resource.record.RRReference;

public class ServiceLocationRecordReference extends RRReference<ServiceLocationRecord,ServiceLocationRecordKey,ServiceLocationRecordView,ServiceLocationRecordModel,ServiceLocationRecordReference,ServiceLocationRecordLibrarian> {
    public ServiceLocationRecordReference(ServiceLocationRecord addressed, ServiceLocationRecordLibrarian resource) {
        super(addressed, resource);
    }
}
