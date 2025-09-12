/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.dns;

import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.authority.AuthorityView;

public class DnsAuthorityView extends AuthorityView<DnsScheme,DnsSchemeView,DnsSchemeModel,DnsAuthority,DnsAuthorityView,DnsAuthorityModel,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsDirectoryContext> {
    public DnsAuthorityView(String name, Authority authority) {
        super(name, authority);
    }
}
