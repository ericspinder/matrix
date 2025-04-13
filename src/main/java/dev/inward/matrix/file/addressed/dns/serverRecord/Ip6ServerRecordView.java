/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

public class Ip6ServerRecordView extends ServerRecordView<Ip6ServerRecordLibrarian,Ip6ServerRecordKey,Ip6ServerRecord,Ip6ServerRecordView,Ip6ServerRecordModel,Ip6ServerRecordReference, Ip6ServerRecordSteward> {
    public Ip6ServerRecordView(Ip6ServerRecord ip6ServerRecord,Ip6ServerRecordModel ip6ServerRecordModel) {
        super("Ip6ServerRecordView", ip6ServerRecord,ip6ServerRecordModel);
    }
}
