/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.ldap;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.library.LibraryModel;

public class LdapLibraryModel extends LibraryModel<LdapScheme,LdapSchemeView,LdapSchemeModel,LdapLibrary,LdapLibraryView,LdapLibraryModel,LdapAuthority,LdapAuthorityView,LdapAuthorityModel,Ldap,LdapKey,LdapView,LdapModel, LdapLibrarian,LdapContext,LdapPath> {
    public LdapLibraryModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
