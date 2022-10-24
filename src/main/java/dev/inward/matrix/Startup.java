package dev.inward.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.creation.Creation;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Boot;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Root;
import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.resources.OSinfo;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.*;
import dev.inward.matrix.datum.Standard;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.datum.Envoy;

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


        deque.add(new Init(new Specification(), new Context.Demarc, agentArgs));


        Map<Standard<?, dev.inward.matrix.datum.fact.notion.concept.boot.Boot,Identity.Ego, Context.Demarc>, Resource<Boot,?,?,?, dev.inward.matrix.datum.fact.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc,Structure, Root>> resourceMap = new ConcurrentHashMap<>();

        Resource<Boot,Instant,Creation, Envoy.NoOp, dev.inward.matrix.datum.fact.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc,Structure,Root> resource = new Resource();
        Boot bootLoader = new Boot(null,);
        bootLoader.preInit(dev.inward.matrix.datum.fact.notion.concept.boot.Boot.class);
        dev.inward.matrix.datum.fact.notion.concept.boot.Boot boot = new dev.inward.matrix.datum.fact.notion.concept.boot.Boot(new Identity.SuperEgo<>(new Context.Demarc(new Edition("Boot",Clock.systemDefaultZone()),true)),new Startup(instrumentation));

    }
    public CommandLine getCommandLine() {
        return this.commandLine;
    }
    public Instrumentation getInstrumentation() {
        return this.instrumentation;
    }
}
