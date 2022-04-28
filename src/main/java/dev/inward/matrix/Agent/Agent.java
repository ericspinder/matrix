package dev.inward.matrix.Agent;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.creation.Creation;
import dev.inward.matrix.datum.creation.Prime;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Edition;
import dev.inward.matrix.datum.fact.notion.concept.boot.*;
import dev.inward.matrix.operational.Options;

import java.lang.instrument.Instrumentation;
import java.time.Clock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Agent {

    private Instrumentation instrumentation;

    private Agent(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        LinkedBlockingDeque<Init> deque = new LinkedBlockingDeque<>();
        Agent agent = new Agent(instrumentation);
        deque.add(new Init(new Options(), new Context.JVM(new Edition(Version.Aforementioned,Clock.systemUTC()),true), agentArgs));
        Map<Class<?>,Resource<BootLoader,?,Boot,Init, Identity.Ego<Context.JVM>,Context.JVM, Structure,Root,Boot,Root,?>> resourceMap = new ConcurrentHashMap<>();

        Resource<BootLoader, Creation,Boot,Init, Identity.Ego<Context.JVM>,Context.JVM, Structure, Root,Boot,Root, Prime> resource = new Resource();
        BootLoader bootLoader = new BootLoader(null,);
        bootLoader.preInit(Boot.class);
        Boot boot = new Boot(new Identity.SuperEgo<>(new Context.JVM(new Edition(Clock.systemDefaultZone()),true)),new Agent(instrumentation));

    }
}
