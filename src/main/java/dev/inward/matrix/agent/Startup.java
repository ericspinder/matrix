package dev.inward.matrix.agent;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.creation.Creation;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.*;
import dev.inward.matrix.meta.Standard;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.rubric.Envoy;

import java.lang.instrument.Instrumentation;
import java.time.Clock;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Startup {

    protected final CommandLine commandLine;
    protected final Instrumentation instrumentation;
    protected final OSinfo oSinfo = new OSinfo();

    public Startup(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        LinkedBlockingDeque<Init> deque = new LinkedBlockingDeque<>();
        Startup startup = new Startup(new CommandLine(agentArgs), instrumentation);


        deque.add(new Init(new Specification(), new Context.JVM, agentArgs));


        Map<Standard<?,Boot,Identity.Ego,Context.JVM>, Resource<BootLoader,?,?,?,Boot,Init,Identity.Ego,Context.JVM,Structure,Root>> resourceMap = new ConcurrentHashMap<>();

        Resource<BootLoader,Instant,Creation, Envoy.NoOp,Boot,Init,Identity.Ego,Context.JVM,Structure,Root> resource = new Resource();
        BootLoader bootLoader = new BootLoader(null,);
        bootLoader.preInit(Boot.class);
        Boot boot = new Boot(new Identity.SuperEgo<>(new Context.JVM(new Edition("Boot",Clock.systemDefaultZone()),true)),new Startup(instrumentation));

    }
    public CommandLine getCommandLine() {
        return this.commandLine;
    }
    public Instrumentation getInstrumentation() {
        return this.instrumentation;
    }
}
