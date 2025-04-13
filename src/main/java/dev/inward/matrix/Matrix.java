/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.container.domain.Domain;
import dev.inward.matrix.container.domain.DomainKey;
import dev.inward.matrix.predictable.Director;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;

public class Matrix {

    private static Matrix Instance;

    protected final Map<String, Director> directorsByDomain = new HashMap<>();
    protected final InitialDirContext dirContext;
    private final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    private final CommandLine commandLine;
    private final Instrumentation instrumentation;
    private final Domain localhostDomain;

    public static Matrix getInstance() {
        return Instance;
    }



    protected Matrix(CommandLine commandLine, Instrumentation instrumentation, Domain localhostDomain) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
        this.localhostDomain = localhostDomain;
        try {
            this.dirContext = new InitialDirContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        try {
            CommandLine commandLine = new CommandLine(agentArgs);
            if (Instance != null) {
                throw new RuntimeException("premain cannot be called twice");
            }
            Instance = new Matrix(commandLine, instrumentation, Domain.get((new DomainKey.Builder()).setDomainName("localhost").setTerrene(Terrene.Parse(commandLine.getValue("terrene"))).buildMatrixKey()));

        } catch (IOException e) {
            throw new InstantiationException("Cannot create instance of Ziggurat from premain method");
        }
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
    public synchronized Director getDirector(Domain domain) {

        if (directorsByDomain.containsKey(domain.getKey().toUri().toString())) {
            return directorsByDomain.get(domain);
        }
        this.directorsByDomain.put(domain.getDomain(),new Director(null));
        return this.directorsByDomain.get(domain.getDomain());

    }
}
