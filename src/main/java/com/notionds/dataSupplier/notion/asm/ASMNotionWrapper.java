package com.notionds.dataSupplier.notion.asm;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * This class is a starter for ASM Java Bytecode manipulation to create notion
 * https://www.baeldung.com/java-asm
 *
 */
public class ASMNotionWrapper<N,O extends Operational<N,W,T>,W extends Datum<N,O,T>, T extends Container<N,O,W>> extends Notion<N,O,W,T> {

    private Map<Class, Class<Datum>> cache = new HashMap<>();
    private StampedLock creationGate = new StampedLock();

    public ASMNotionWrapper(O options, ClassLoader classLoader) {
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


