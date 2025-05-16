/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.startOfAuthority;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.file.resource.record.RRLibrarian;

public class StartOfAuthorityLibrarian extends RRLibrarian<StartOfAuthority,StartOfAuthorityKey,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference,StartOfAuthorityLibrarian> {

    public StartOfAuthorityLibrarian(Standard standard) {
        super(standard);
    }
}
