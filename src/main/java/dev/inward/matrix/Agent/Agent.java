package dev.inward.matrix.Agent;

import dev.inward.matrix.datum.fact.Factory;

import javax.security.auth.Subject;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.Principal;
import java.security.ProtectionDomain;

public class Agent {

    private Subject subject = new Subject();

    public Agent(Principal principal) {
        this.subject.getPrincipals().add(principal);
    }
    public Subject getSubject() {
        return subject;
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(
                    ClassLoader l,
                    String name,
                    Class c,
                    ProtectionDomain d,
                    byte[] b)
                    throws IllegalClassFormatException {
                if (l instanceof Factory) {
                    byte[]  ((Factory<?, ?, ?, ?, ?, ?, ?, ?, ?>) l).init(name);
                }
                return b;
            }
        });
    }
}
