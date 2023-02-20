package dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat;

import dev.inward.matrix.CommandLine;

import java.lang.instrument.Instrumentation;

public class Startup {



    public Startup(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
        this.os = parseOS();
        this.osVersion = System.getProperty("os.version");
    }
    private static Root root;
    public static final Root root() {
        return root;
    }


    public CommandLine getCommandLine() {
        return this.commandLine;
    }

}
