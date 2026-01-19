/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns;

import dev.inward.matrix.Shadow;
import dev.inward.matrix.concept.fact.directory.Directory;
import dev.inward.matrix.concept.fact.directory.DirectoryLibrarian;

public class DnsDirectoryReference implements Shadow<DnsDirectory> {

    public DnsDirectoryReference(Directory referent, DirectoryLibrarian librarian) {
        super(referent, librarian);
    }
}
