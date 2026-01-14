/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.terrene.*;
import dev.inward.matrix.concept.fact.addressed.dns.ResourceRecordType;
import dev.inward.matrix.concept.fact.addressed.dns.catalogRecord.CatalogRecord;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Ziggurat extends URLStreamHandler {

    private static Ziggurat Instance;
    public static Ziggurat getInstance() {
        return Instance;
    }

    private final Map<String, WeakReference<Domain>> allBuiltDomains = new ConcurrentHashMap<>();
    private transient final InitialDirContext dirContext;

    private transient final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    private final CommandLine commandLine;
    private transient final Instrumentation instrumentation;
    private final Domain localhostDomain;

    private final Map<String, ControlModel<?,?,?>> controlModels = new HashMap<>();


    private Ziggurat(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
        try {
            this.dirContext = new InitialDirContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        this.localhostDomain = getDomain(Terrene.Parse(commandLine.getValue("terrene")), "localhost");
    }

    @Override
    protected MatrixConnection openConnection(URL u) throws IOException {
        return null;
    }

    public CatalogRecord getCatalogRecord(Authority<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> authority, Protocol protocol) {
        try {
            authority.getDomain()
            DnsDirectoryKey directoryKey = (new DnsDirectoryKey.Builder()).setPath(new DnsPath(authority.getDomain().getDomainName(), ResourceRecordType.CatalogRecord)).setLibrary(authority).buildMatrixKey();


        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }


    public Domain getDomain(Terrene terrene, String domainName) {
        String domainKey = terrene.toString() + domainName;
        if (!allBuiltDomains.containsKey(domainKey) || allBuiltDomains.get(domainKey).get() == null) {
            return newDomain(terrene, domainName);
        }
        return allBuiltDomains.get(domainKey).get();
    }
    protected synchronized Domain newDomain(Terrene terrene, String domainName, Director director) {
        String domainKey = terrene.toString() + "_" + domainName;
        if (!allBuiltDomains.containsKey(domainKey) || allBuiltDomains.get(domainKey).get() == null) {
            Domain domain = new Domain(terrene, domainName, director);
            allBuiltDomains.put(domainKey,new WeakReference<>(domain));
            return domain;
        }
        return allBuiltDomains.get(domainKey).get();
    }
    public LocalSystemNetworking getLocalSystemNetworking() {
        return this.localSystemNetworking;
    }

    public CommandLine getCommandLine() {
        return commandLine;
    }

    public Domain getLocalhostDomain() {
        return localhostDomain;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }

    public InitialDirContext getDirContext() {
        return dirContext;
    }

}
