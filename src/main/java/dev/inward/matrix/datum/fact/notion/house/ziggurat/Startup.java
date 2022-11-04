package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.CommandLine;
import dev.inward.matrix.NotionStartupException;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.creation.Creation;
import dev.inward.matrix.engine.Edition;
import dev.inward.matrix.datum.fact.matter.Indicia;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.*;
import dev.inward.matrix.datum.Standard;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.datum.Envoy;

import java.lang.instrument.Instrumentation;
import java.time.Clock;
import java.time.Instant;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Startup {



    public Startup(CommandLine commandLine, Instrumentation instrumentation) {
        this.commandLine = commandLine;
        this.instrumentation = instrumentation;
        this.os = parseOS();
        this.osVersion = System.getProperty("os.version");
    }
    private static Root root;
    public static final Root root() {
        return root;
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
    private OS parseOS() {
        String osName = System.getProperty("os.name");
        if (osName == null) {
            throw new NotionStartupException(NotionStartupException.Type.UnableToParseOS, this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Unexpected,null);
        }
        osName = osName.toLowerCase(Locale.ENGLISH);
        if (osName.contains("windows")) {
            return OS.WINDOWS;
        } else if (osName.contains("linux")
                || osName.contains("mpe/ix")
                || osName.contains("freebsd")
                || osName.contains("irix")
                || osName.contains("digital unix")
                || osName.contains("unix")) {
            return OS.UNIX;
        } else if (osName.contains("mac os")) {
            return OS.MAC;
        } else if (osName.contains("sun os")
                || osName.contains("sunos")
                || osName.contains("solaris")) {
            return OS.POSIX_UNIX;
        } else if (osName.contains("hp-ux")
                || osName.contains("aix")) {
            return OS.POSIX_UNIX;
        } else {
            return OS.OTHER;
        }
    }

    public enum OS {
        WINDOWS,
        UNIX,
        POSIX_UNIX,
        MAC,
        OTHER;
    }
}
