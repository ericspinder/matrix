/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.file.addressed.dns.ResourceRecordType;
import dev.inward.matrix.file.addressed.dns.catalogRecord.LibraryRecord;
import dev.inward.matrix.predictable.Director;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.lang.instrument.Instrumentation;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Matrix {

    protected static final Map<String, Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> ALL_KNOWN_SCHEMES = new HashMap<>();

    public static Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> findSchemeByString(String scheme_s) {
        String lowerCaseScheme = scheme_s.toLowerCase();
        String schemeCacheKey;
        Terrene terrene;
        if (lowerCaseScheme.lastIndexOf('.') == -1) {
            terrene = Terrene.Earth;
            schemeCacheKey =  terrene.dnsClassCode + "_" + lowerCaseScheme;
        }
        else {
            terrene = Terrene.Parse(lowerCaseScheme.substring(0,lowerCaseScheme.lastIndexOf('.')));
            schemeCacheKey = terrene.dnsClassCode + "_" + lowerCaseScheme.substring(lowerCaseScheme.lastIndexOf('.'));
        }
        Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> scheme = ALL_KNOWN_SCHEMES.get(schemeCacheKey);
        if (scheme == null) {
            synchronized (ALL_KNOWN_SCHEMES) {
                scheme = ALL_KNOWN_SCHEMES.get(schemeCacheKey);
                if (scheme == null) {
                    String protocol_s = lowerCaseScheme.substring(lowerCaseScheme.lastIndexOf('.'));
                    for (MatrixURLStreamHandlerProvider.Protocol protocol: MatrixURLStreamHandlerProvider.Protocol.values()) {
                        if (protocol.getLabel().equals(protocol_s)) {
                            try {
                                scheme = new Scheme<>(terrene, protocol.parserClass.getConstructor().newInstance());
                                ALL_KNOWN_SCHEMES.put(schemeCacheKey,scheme);
                                return scheme;
                            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                                     InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    throw new RuntimeException("Protocol not found" + protocol_s);
                }
            }
        }
        return scheme;
    }

    private static Matrix Instance;
    public static Matrix getInstance() {
        return Instance;
    }

    private final Map<String, WeakReference<Domain>> allBuiltDomains = new ConcurrentHashMap<>();
    protected final InitialDirContext dirContext;
    private final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    private final CommandLine commandLine;
    private final Instrumentation instrumentation;
    private final Domain localhostDomain;

    protected final Map<Class<? extends Control<?,?,?>>,Model<? extends Control<?,?,?>>> controlModels = new HashMap<>();


    protected Matrix(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
        try {
            this.dirContext = new InitialDirContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        this.localhostDomain = getDomain(Terrene.Parse(commandLine.getValue("terrene")), "localhost");
    }
    public LibraryRecord getCatalogRecord(Authority<?,?,?,?,?,?,?> authority, MatrixURLStreamHandlerProvider.Protocol protocol) {
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
