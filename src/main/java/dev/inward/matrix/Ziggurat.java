package dev.inward.matrix;

import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Road;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class Ziggurat implements URLStreamHandlerFactory {

    private static Ziggurat Instance = null;
    private final Map<String, Scheme<?,?,?>> schemeMap = new ConcurrentHashMap<>();

    public static Ziggurat getInstance() {
        return Instance;
    }

    private final LocalSystemNetworking localSystemNetworking = LocalSystemNetworking.getInstance();
    private final CommandLine commandLine;
    private final Instrumentation instrumentation;

    private final Dispatch.Network networkDispatch = new Dispatch.Network(null, "networkDispatch", "top level dispatch", 10,100,1, TimeUnit.HOURS,500);
    private final Dispatch.DriverFactory<Dispatch.Network,Road.Network> networkDriverFactory = new Dispatch.DriverFactory<>(networkDispatch, "network");
    private final Road.Network networkRoad = new Road.Network(networkDispatch,new LinkedBlockingQueue<>(),networkDriverFactory);
    private final Director.Network networkDirector = new Director.Network(networkRoad);

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

    public Director.Network getNetworkDirector() {
        return networkDirector;
    }


    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        try {
            if (Instance == null) {
                Instance = new Ziggurat(new CommandLine(agentArgs), instrumentation);
            }

        }
        catch (IOException e) {
            System.out.println(e.toString());
        }

//        deque.add(new Init(new Specification(), new Context.Demarc, agentArgs));


//        Map<Standard<?, dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot,Identity.Ego, Context.Demarc>, Resource<Boot,?,?,?, dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc, Structure, Root>> resourceMap = new ConcurrentHashMap<>();
//
//        Resource<Boot, Instant, Creation, Envoy.NoOp, dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot,Init,Identity.Ego, Context.Demarc,Structure,Root> resourceRecord = new Resource();
//        Boot bootLoader = new Boot(null,);
//  //      bootLoader.preInit(dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot.class);
//        dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot boot = new dev.inward.source.fact.tracked.authoritative.notion.concept.boot.Boot(new Identity.SuperEgo<>(new Context.Demarc(new Edition("Boot", Clock.systemDefaultZone()),true)),new Startup(instrumentation));

    }

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
            return Scheme.findSchemeByString(protocol);
    }
}
