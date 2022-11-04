package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.CommandLine;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.house.House;
import dev.inward.matrix.resources.LocalSystemNetworking;
import dev.inward.matrix.resources.Resource;

import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;

public class Ziggurat extends House<Ziggurat,Root> {

    protected final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    protected final CommandLine commandLine;
    protected final Instrumentation instrumentation;
    protected final Startup.OS os;
    protected final String osVersion;

    protected final Map<Context.Ethereal, Authority> etherealAuthorityMap = new HashMap<>();

    protected Map<String,? super Resource<?>> datumMap = new HashMap<>();

    protected Ziggurat(Identity.Ghost ghost, CommandLine commandLine, Instrumentation instrumentation, Startup.OS os, String osVersion) {
        super(ghost);
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
        this.os = os;
        this.osVersion = osVersion;
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

    public Startup.OS getOs() {
        return os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public Map<Context.Ethereal, Authority> getEtherealAuthorityMap() {
        return etherealAuthorityMap;
    }


}
