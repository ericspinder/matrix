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

public class PlatformAgent extends Agent {

    private Instrumentation instrumentation;
    private CommandLine commandLine;
    private LocalSystemNetworking localSystemNetworking = new LocalSystemNetworking();

    public PlatformAgent(Principal principal, Instrumentation instrumentation) {
        super(principal);
        this.instrumentation = instrumentation;
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        CommandLine commandLine = new CommandLine(agentArgs);
        LinkedBlockingDeque<Init> deque = new LinkedBlockingDeque<>();
        UnixPrincipal unixPrincipal = new UnixPrincipal(System.getenv("user.name"));
        PlatformAgent agent = new PlatformAgent(unixPrincipal,instrumentation);
        deque.add(new Init(new Options(), new Context.JVM(), agentArgs));
        Map<Class<?>, Resources<BootLoader,?,?,Boot,Init, Identity.Ego<Context.JVM>,Context.JVM, Structure,Root,Boot,Root,?>> resourceMap = new ConcurrentHashMap<>();

        Resources<BootLoader,Instant,Creation,Boot,Init, Identity.Ego<Context.JVM>,Context.JVM, Structure, Root,Boot,Root, Prime> resources = new Resources();
        BootLoader bootLoader = new BootLoader(null,);
        bootLoader.preInit(Boot.class);
        Boot boot = new Boot(new Identity.SuperEgo<>(new Context.JVM(new Edition("Boot",Clock.systemDefaultZone()),true)),new PlatformAgent(instrumentation));

    }
    public CommandLine getCommandLine() {
        return this.commandLine;
    }
    public Instrumentation getInstrumentation() {
        return this.instrumentation;
    }
}
