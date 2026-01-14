/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.ldap;

import dev.inward.matrix.concept.fact.addressed.depot.standard.Standard;
import dev.inward.matrix.concept.fact.directory.DirectoryLibrarian;

public class LdapLibrarian extends DirectoryLibrarian<LdapScheme,LdapSchemeView,LdapSchemeModel,LdapLibrary,LdapLibraryView,LdapLibraryModel,LdapAuthority,LdapAuthorityView,LdapAuthorityModel,Ldap,LdapKey,LdapView,LdapModel, LdapLibrarian,LdapContext,LdapPath> {
    public LdapLibrarian(Standard standard) {
        super(standard);
    }
}
