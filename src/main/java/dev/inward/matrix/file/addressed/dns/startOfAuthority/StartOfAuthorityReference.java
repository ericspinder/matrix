/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.file.addressed.dns.RRReference;

public class StartOfAuthorityReference extends RRReference<StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityReference,StartOfAuthorityAttributes,StartOfAuthorityResource,StartOfAuthorityModel> {
    public StartOfAuthorityReference(StartOfAuthority addressed, StartOfAuthorityResource resource) {
        super(addressed, resource);
    }
}
