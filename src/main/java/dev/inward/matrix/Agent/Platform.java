package dev.inward.matrix.Agent;

import com.sun.security.auth.UnixPrincipal;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.creation.Creation;
import dev.inward.matrix.datum.creation.Prime;
import dev.inward.matrix.datum.fact.Resources;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.*;
import dev.inward.matrix.operational.Options;

import java.lang.instrument.Instrumentation;
import java.security.Principal;
import java.time.Clock;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Platform {

    protected final CommandLine commandLine;
    protected final Instrumentation instrumentation;
    protected final OSinfo oSinfo = new OSinfo();

    public Platform(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        LinkedBlockingDeque<Init> deque = new LinkedBlockingDeque<>();
        Platform platform = new Platform(new CommandLine(agentArgs), instrumentation);


        deque.add(new Init(new Options(), new Context.JVM(), agentArgs));
        Map<Class<?>, Resources<BootLoader,?,?,Boot,Init, Identity.Ego,Context.JVM, Structure,Root,Boot>> resourceMap = new ConcurrentHashMap<>();

        Resources<BootLoader,Instant,Creation,Boot,Init, Identity.Ego,Context.JVM, Structure, Root,Boot> resources = new Resources();
        BootLoader bootLoader = new BootLoader(null,);
        bootLoader.preInit(Boot.class);
        Boot boot = new Boot(new Identity.SuperEgo<>(new Context.JVM(new Edition("Boot",Clock.systemDefaultZone()),true)),new Platform(instrumentation));

    }
    public CommandLine getCommandLine() {
        return this.commandLine;
    }
    public Instrumentation getInstrumentation() {
        return this.instrumentation;
    }
}
