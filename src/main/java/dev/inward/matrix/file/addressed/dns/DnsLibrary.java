/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.*;
import dev.inward.matrix.file.addressed.AddressedLibrary;
import dev.inward.matrix.memory.Memory;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DnsLibrary extends Library<DnsScheme,DnsLibraryKey, DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel> {
    public DnsLibrary(DnsLibraryKey libraryKey) {
        super(libraryKey);
    }

    @Override
    protected Map<DnsCatalog, Memory<DnsScheme,DnsLibraryKey, DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel>[]> initCatalogs() {
        try {
            DirContext dirContext = new InitialDirContext();
            NamingEnumeration<?> nameServerEnumeration = dirContext.getAttributes("dns:" + libraryKey.getDomain() + ".",new String[]{"NS"}).get("NS").getAll();
            List<InetAddress> nameServers = new ArrayList<>();
            while (nameServerEnumeration.hasMoreElements()) {
                try {
                    nameServers.add(InetAddress.getByName(nameServerEnumeration.next().toString()));
                } catch (UnknownHostException e) {
                    System.out.println("Unknown Name Server " + e);
                }
            }
            DnsCatalog dnsCatalog = new DnsCatalog(new DnsCatalogKey(new URI(libraryKey.getUri() + "?startPath=*,endPath=*"),this));
            List<HostExperience> hostExperiences = new ArrayList<>();
            for (LocalSystemNetworking.NetworkMapping networkMapping: Ziggurat.getInstance().getLocalSystemNetworking().getExternalActiveInterfaces().keySet()) {
                if (nameServers.contains(networkMapping.getInterfaceAddress().getAddress())) {
                    nameServers.remove(networkMapping.getInterfaceAddress().getAddress());
                    HostExperience.Server serverExperience = new HostExperience.Server(networkMapping);
                    hostExperiences.add(serverExperience);
                    this.initServer(serverExperience,dnsCatalog);
                }
            }
            for (InetAddress inetAddress: nameServers) {
                hostExperiences.add(new HostExperience.Client(inetAddress,10));
            }
            Map<DnsCatalog,HostExperience[]> catalogHostExperienceMap = new HashMap<>();
            catalogHostExperienceMap.put(dnsCatalog,hostExperiences.toArray(new HostExperience[0]));
            return catalogHostExperienceMap;
        } catch (NamingException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
