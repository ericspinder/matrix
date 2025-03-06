/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.dns.*;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;

public class Ziggurat {

    private static Ziggurat Instance = null;

    protected final Map<String,Director> directorsByDomain = new HashMap<>();
    protected final InitialDirContext dirContext;

    public static Ziggurat getInstance() {
        return Instance;
    }

    private final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    private final CommandLine commandLine;
    private final Instrumentation instrumentation;

    private Ziggurat(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
        try {
            this.dirContext = new InitialDirContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public LocalSystemNetworking getLocalSystemNetworking() {
        return localSystemNetworking;
    }

    public CommandLine getCommandLine() {
        return commandLine;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }

    public synchronized Director getDirector(Domain domain) {
        if (directorsByDomain.containsKey(domain.getDomain())) {
            return directorsByDomain.get(domain.getDomain());
        }
        this.directorsByDomain.put(domain.getDomain(),new Director(domain));
        return this.directorsByDomain.get(domain.getDomain());

    }


    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        try {
            if (Instance == null) {
                Instance = new Ziggurat(new CommandLine(agentArgs), instrumentation);
            }
        }
        catch (IOException e) {
            throw new InstantiationException("Cannot create instance of Ziggurat from premain method");
        }
    }
    public final <K extends RRKey<K,F,R,A,RESOURCE,M>, F extends ResourceRecord<K,F,R,A,RESOURCE,M>,R extends RRReference<K,F,R,A,RESOURCE,M>,A extends RRAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends RRResource<K,F,R,A,RESOURCE,M>,M extends RRModel<K,F,R,A,RESOURCE,M>> R findRecord(DnsPath dnsPath,Class<K> expectedClass) {
        try {
            Attribute attr = dirContext.getAttributes("dns:" + dnsPath.getDomain(), new String[] {dnsPath.type().getLabel()}).get(dnsPath.type().getLabel());
            if (attr == null) {
                attr = dirContext.getAttributes("dns:" + dnsPath.getDomain(), new String[] {ResourceRecordType.text.getLabel()}).get(ResourceRecordType.text.getLabel());
            }
            if (attr == null) {
                throw new RuntimeException("Cannot find Resource Records for " + dnsPath.getDomain() + ", RR Type = " + dnsPath.type().getLabel() + " (or TXT records at all) for " + dnsPath.getTerrene().aliases[0]);
            }
            NamingEnumeration<?> enumeration = attr.getAll();
            while (enumeration.hasMore()) {
                String element = (String) enumeration.next();
                String[] parts  = element.split(" ");
                for (String part: parts) {
                    try {
                        expectedClass.
                    }
                    finally {

                    }

                }
            }
        } catch (NamingException | ClassCastException e) {
            throw new RuntimeException(e);
        }
    }
}
