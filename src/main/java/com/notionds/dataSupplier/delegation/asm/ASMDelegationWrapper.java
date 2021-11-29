package com.notionds.dataSupplier.delegation.asm;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.delegation.Delegation;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.operational.Operational;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

/**
 * This class is a starter for ASM Java Bytecode manipulation to create delegation
 * https://www.baeldung.com/java-asm
 *
 */
public class ASMDelegationWrapper<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T>, T extends Container<N,O,W>> extends Delegation<N,O,W,T> {

    private Map<Class, Class<Wrapper>> cache = new HashMap<>();
    private StampedLock creationGate = new StampedLock();

    public ASMDelegationWrapper(O options, ClassLoader classLoader) {
        super(options, classLoader);
    }

    @Override
    public W getDelegate(T container, N delegate, Object[] args) {
        Class<Wrapper> delegateClass = cache.get(null);
        if (delegateClass == null) {
            // The autostart should have captured all of the classes needed
        }
        throw new UnsupportedOperationException("Stub class not completed");
    }

}


