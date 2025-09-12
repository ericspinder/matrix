/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.local;

import dev.inward.matrix.CommandLine;
import dev.inward.matrix.Matrix;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.predictable.Director;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class  Local implements Control<Local,LocalView,LocalModel> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createTime = Instant.now();


    public Local() {


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

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Instant getCreateInstant() {
        return createTime;
    }

    protected Map<String, Director> directorByTerrene_Domain = new HashMap<>();

    public void addDirector(Domain domain, Director director) {
        this.directorByTerrene_Domain.put(domain.getTerrene() + "_" + domain.getDomainName(), director);
    }
    public void removeDirector(Domain domain) {
        this.directorByTerrene_Domain.remove(domain.getTerrene() + "_" + domain.getDomainName());
    }
}
