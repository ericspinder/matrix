/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.nameServerRecord;

import dev.inward.matrix.file.addressed.dns.RRView;

public class NameServerRecordView extends RRView<NameServerRecordKey,NameServerRecord,NameServerRecordView,NameServerRecordModel,NameServerRecordReference,NameServerRecordLibrarian> {

    public NameServerRecordView(String name, NameServerRecord file, NameServerRecordReference fileReference) {
        super(name, file, fileReference);
    }
}
