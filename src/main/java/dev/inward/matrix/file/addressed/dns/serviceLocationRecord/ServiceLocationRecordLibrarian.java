/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serviceLocationRecord;

import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.file.addressed.dns.RRLibrarian;

public class ServiceLocationRecordLibrarian extends RRLibrarian<ServiceLocationRecord,ServiceLocationRecordKey,ServiceLocationRecordView,ServiceLocationRecordModel, ServiceLocationRecordReference, ServiceLocationRecordLibrarian> {

    public ServiceLocationRecordLibrarian(Standard standard) {
        super(standard);
    }
}
