/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns;

import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.terrene.Terrene;
import org.jetbrains.annotations.NotNull;

public class DnsScheme extends Scheme<DnsScheme,DnsSchemeView,DnsSchemeModel,DnsAuthority,DnsAuthorityView,DnsAuthorityModel,DnsLibrary,DnsLibraryView,DnsLibraryModel,DnsDirectory,DnsDirectoryKey,DnsDirectoryView,DnsDirectoryModel,DnsDirectoryReference,DnsDirectoryLibrarian,DnsDirectoryContext,DnsPath> {

    @SuppressWarnings("unchecked")
    public DnsScheme(Terrene terrene) {
        super(terrene, ProtocolParser.Instances.DNS);
    }

    @Override
    protected DnsLibrary createNewLibrary(Domain domain, int port) {


    }

    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }
}
