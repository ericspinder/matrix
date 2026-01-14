/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.ldap;

import dev.inward.matrix.concept.fact.directory.DirectoryKey;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class LdapKey extends DirectoryKey<LdapScheme,LdapSchemeView,LdapSchemeModel,LdapLibrary,LdapLibraryView,LdapLibraryModel,LdapAuthority,LdapAuthorityView,LdapAuthorityModel,Ldap,LdapKey,LdapView,LdapModel, LdapLibrarian,LdapContext,LdapPath> {

    protected LdapKey(URI uri, LdapPath directoryPath, LdapModel directoryModel) {
        super(uri, directoryPath, directoryModel);
    }

    @Override
    protected URL processUri(URI uri) {
        return null;
    }

    @NotNull
    @Override
    public WatchKey register(@NotNull WatchService watcher, WatchEvent.@NotNull Kind<?>[] events, @NotNull WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }
}
