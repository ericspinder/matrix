package dev.inward.matrix.fact.authoritative.notion.authority.matrix.ziggurat;

import dev.inward.matrix.CommandLine;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.authority.Authority;
import dev.inward.matrix.fact.authoritative.notion.authority.matrix.Matrix;
import dev.inward.matrix.resources.LocalSystemNetworking;
import dev.inward.matrix.resources.Resource;

import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Ziggurat extends Matrix {

    protected final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    protected final CommandLine commandLine;
    protected final Instrumentation instrumentation;

    protected final Map<Context.Ethereal, Authority> etherealAuthorityMap = new HashMap<>();

    protected Map<String,? super Resource<?>> datumMap = new HashMap<>();

    public Ziggurat(Identity.Ghost ghost, CommandLine commandLine, Instrumentation instrumentation) {
        super(ghost,null,null,null);
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

    public Map<Context.Ethereal, Authority> getEtherealAuthorityMap() {
        return etherealAuthorityMap;
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        LinkedBlockingDeque<Init> deque = new LinkedBlockingDeque<>();
        Startup startup = new Startup(new CommandLine(agentArgs), instrumentation);

//        deque.add(new Init(new Specification(), new Context.Demarc, agentArgs));


//        Map<Standard<?, dev.inward.matrix.fact.tracked.authoritative.notion.concept.boot.Boot,Identity.Ego, Context.Demarc>, Resource<Boot,?,?,?, dev.inward.matrix.fact.tracked.authoritative.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc, Structure, Root>> resourceMap = new ConcurrentHashMap<>();
//
//        Resource<Boot, Instant, Creation, Envoy.NoOp, dev.inward.matrix.fact.tracked.authoritative.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc,Structure,Root> resource = new Resource();
//        Boot bootLoader = new Boot(null,);
//  //      bootLoader.preInit(dev.inward.matrix.fact.tracked.authoritative.notion.concept.boot.Boot.class);
//        dev.inward.matrix.fact.tracked.authoritative.notion.concept.boot.Boot boot = new dev.inward.matrix.fact.tracked.authoritative.notion.concept.boot.Boot(new Identity.SuperEgo<>(new Context.Demarc(new Edition("Boot", Clock.systemDefaultZone()),true)),new Startup(instrumentation));

    }
}
