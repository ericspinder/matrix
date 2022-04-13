package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Effect;

public class Init extends Effect<BootLoader,Boot,Init, Context.JVM,Structure,Root> {

    private final String agentArgs;

    public Init(String agentArgs) {
        this.agentArgs = agentArgs;
    }

    public String getAgentArgs() {
        return this.agentArgs;
    }
}
