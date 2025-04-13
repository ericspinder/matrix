/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.file.addressed.dns.RRView;

public class StartOfAuthorityView extends RRView<StartOfAuthorityLibrarian,StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference, StartOfAuthoritySteward> {

    public StartOfAuthorityView(String name, StartOfAuthority resourceRecord, StartOfAuthorityModel rrModel) {
        super(name, resourceRecord, rrModel);
    }
}
