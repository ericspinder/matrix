package dev.inward.matrix.Agent;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Edition;
import dev.inward.matrix.datum.fact.notion.concept.boot.Boot;
import dev.inward.matrix.datum.fact.notion.concept.boot.BootLoader;
import dev.inward.matrix.datum.fact.notion.concept.boot.Init;

import java.lang.instrument.Instrumentation;
import java.time.Clock;
import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Agent {

    private Instrumentation instrumentation;

    private Agent(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }
    public static void premain(String agentArgs, Instrumentation instrumentation) throws InstantiationException {
        LinkedBlockingDeque<Init> deque = new LinkedBlockingDeque<>();
        deque.add(new Init(agentArgs));
        BootLoader bootLoader = new BootLoader(deque,null);
        bootLoader.preInit(Boot.class);
        Boot boot = new Boot(new Identity.SuperEgo<>(new Context.JVM(new Edition(Clock.systemDefaultZone()),true)),new Agent(instrumentation));

    }
}
