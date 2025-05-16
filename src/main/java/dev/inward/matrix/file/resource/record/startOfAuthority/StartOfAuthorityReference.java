/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.startOfAuthority;

import dev.inward.matrix.file.resource.record.RRReference;

public class StartOfAuthorityReference extends RRReference<StartOfAuthority,StartOfAuthorityKey,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference,StartOfAuthorityLibrarian> {

    public StartOfAuthorityReference(StartOfAuthority referent, StartOfAuthorityLibrarian librarian) {
        super(referent, librarian);
    }
}
