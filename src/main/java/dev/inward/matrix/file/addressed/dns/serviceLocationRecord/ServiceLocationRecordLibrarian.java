/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serviceLocationRecord;

import dev.inward.matrix.file.addressed.dns.ResourceRecordLibrarian;

public class ServiceLocationRecordLibrarian extends ResourceRecordLibrarian<ServiceLocationRecordLibrarian,ServiceLocationRecordKey,ServiceLocationRecord,ServiceLocationRecordView,ServiceLocationRecordModel,ServiceLocationRecordReference, ServiceLocationRecordSteward> {
    protected ServiceLocationRecordLibrarian(ServiceLocationRecordSteward gestalt) {
        super(gestalt);
    }
}
