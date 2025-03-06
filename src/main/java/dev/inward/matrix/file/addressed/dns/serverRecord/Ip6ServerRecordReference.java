/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

public class Ip6ServerRecordReference extends ServerRecordReference<Ip6ServerRecordKey,Ip6ServerRecord,Ip6ServerRecordReference,Ip6ServerRecordAttributes,Ip6ServerRecordResource,Ip6ServerRecordModel>{
    public Ip6ServerRecordReference(Ip6ServerRecord addressed, Ip6ServerRecordResource resource) {
        super(addressed, resource);
    }
}
