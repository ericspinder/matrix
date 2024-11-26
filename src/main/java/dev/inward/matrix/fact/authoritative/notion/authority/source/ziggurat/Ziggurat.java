package dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat;

import dev.inward.matrix.CommandLine;
import dev.inward.matrix.Context;
import dev.inward.matrix.Host;
import dev.inward.matrix.authority.source.Source;
import dev.inward.matrix.resources.LocalSystemNetworking;
import dev.inward.matrix.Resource;

import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public final class Ziggurat {

    private static Ziggurat Instance = null;

    public static Ziggurat getInstance() {
        return Instance;
    }

    private final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    private final CommandLine commandLine;
    private final Instrumentation instrumentation;

    private final Map<> etherealAuthorityMap = new HashMap<>();

    private Map<String,? super Resource<?>> datumMap = new HashMap<>();

    private Ziggurat(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
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

    public Map<Context.Ethereal, Host> getEtherealAuthorityMap() {
        return etherealAuthorityMap;
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        Instance = new Ziggurat(new CommandLine(agentArgs),instrumentation);

//        deque.add(new Init(new Specification(), new Context.Demarc, agentArgs));


//        Map<Standard<?, dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot,Identity.Ego, Context.Demarc>, Resource<Boot,?,?,?, dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc, Structure, Root>> resourceMap = new ConcurrentHashMap<>();
//
//        Resource<Boot, Instant, Creation, Envoy.NoOp, dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc,Structure,Root> resourceRecord = new Resource();
//        Boot bootLoader = new Boot(null,);
//  //      bootLoader.preInit(dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot.class);
//        dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot boot = new dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot(new Identity.SuperEgo<>(new Context.Demarc(new Edition("Boot", Clock.systemDefaultZone()),true)),new Startup(instrumentation));

    }
}
