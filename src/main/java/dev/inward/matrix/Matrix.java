/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.file.addressed.dns.*;
import dev.inward.matrix.file.resource.record.DnsDirectoryKey;
import dev.inward.matrix.file.resource.record.DnsPath;
import dev.inward.matrix.file.resource.record.ResourceRecordType;
import dev.inward.matrix.file.resource.record.catalogRecord.CatalogRecord;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Matrix {

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
    public CatalogRecord getCatalogRecord(Authority<?,?,?,?,?,?,?> authority, MatrixURLStreamHandlerProvider.Protocol protocol) {
        try {
            this.dirContext.getAttributes("dns:" + authority.getDomain().getDomainName() + ".", new String[] {"TXT"});
            DnsDirectoryKey directoryKey = (new DnsDirectoryKey.Builder()).setPath(new DnsPath(authority.getDomain().getDomainName(), ResourceRecordType.CatalogRecord)).setLibrary(authority).buildMatrixKey();


        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public Domain getDomain(Terrene terrene, String domainName) {
        String domainKey = terrene.toString() +domainName;
        if (!allBuiltDomains.containsKey(domainKey) || allBuiltDomains.get(domainKey).get() == null) {
            return newDomain(terrene, domainName);
        }
        return allBuiltDomains.get(domainKey).get();
    }
    protected synchronized Domain newDomain(Terrene terrene, String domainName) {
        String domainKey = terrene.toString() + "_" + domainName;
        if (!allBuiltDomains.containsKey(domainKey) || allBuiltDomains.get(domainKey).get() == null) {
            Domain domain = new Domain(terrene, domainName);
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
    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        try {
            if (Instance != null) {
                throw new RuntimeException("premain cannot be called twice");
            }
            Instance = new Matrix(new CommandLine(agentArgs), instrumentation);

        } catch (IOException e) {
            throw new InstantiationException("Cannot create instance of Ziggurat from premain method");
        }
    }
}
