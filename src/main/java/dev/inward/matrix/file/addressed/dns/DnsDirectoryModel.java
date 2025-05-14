/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.directory.DirectoryModel;

public class DnsDirectoryModel extends DirectoryModel<DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsPath> {
    public DnsDirectoryModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
