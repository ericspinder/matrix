package crud.asm;

import dev.inward.crud.Container;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.operational.Operational;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * This class is a starter for ASM Java Bytecode manipulation to create notion
 * https://www.baeldung.com/java-asm
 *
 */
public class ASMFactWrapper<N,O extends Operational<N,W,T>,W extends Datum<N,O,T>, T extends Container<N,O,W>> extends Fact<N,O,W,T> {

    private Map<Class, Class<Datum>> cache = new HashMap<>();
    private StampedLock creationGate = new StampedLock();

    public ASMFactWrapper(O options, ClassLoader classLoader) {
        super(options, classLoader);
    }

    @Override
    public W getDelegate(T container, N delegate, Object[] args) {
        Class<Datum> delegateClass = cache.get(null);
        if (delegateClass == null) {
            // The autostart should have captured all of the classes needed
        }
        throw new UnsupportedOperationException("Stub class not completed");
    }

}


