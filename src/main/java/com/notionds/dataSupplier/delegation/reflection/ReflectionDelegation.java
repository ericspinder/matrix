package com.notionds.dataSupplier.delegation.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.aggregation.InvokeAggregator;
import com.notionds.dataSupplier.delegation.Delegation;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.operational.Operational;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ReflectionDelegation<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T> & InvocationHandler, T extends Container<N,O,W>> extends Delegation<N,O,W,T> {

    private static final Logger logger = LogManager.getLogger();

    public static class Default<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T> & InvocationHandler, T extends Container<N,O,W>> extends ReflectionDelegation<N,O,W,T> {

        public Default(O options, ClassLoader classLoader) {
            super(options, classLoader);
        }

        @Override
        public InvocationHandler wrapper(N delegate, O operational, T container) {
            return new Proxy(delegate, operational, container);
        }
    }
    public static class AggregationDefault<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T> & InvocationHandler, T extends Container<N,O,W>, G extends InvokeAggregator, I extends InvokeInterceptor<N,O,W,T,G>> extends ReflectionDelegation<N,O,W,T> {

        private final I invokeInterceptor;
        public AggregationDefault(O options, ClassLoader classLoader, I invokeInterceptor) {
            super(options, classLoader);
            this.invokeInterceptor = invokeInterceptor;
        }

        @Override
        public InvocationHandler wrapper(N delegate, O operational, T container) {
            return new ProxyForAggregation(delegate, operational, container, invokeInterceptor);
        }
    }

    public ReflectionDelegation(O options, ClassLoader classLoader) {
        super(options, classLoader);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final W getDelegate(T container, N delegate, Object[] args) {
        if (this.delegateClass.isInterface()) {
            Class<?>[] interfaces = this.getConnectionMemberInterfaces(delegateClass);
            if (interfaces != null) {
                return (W) java.lang.reflect.Proxy.newProxyInstance(
                        ReflectionDelegation.class.getClassLoader(),
                        interfaces,
                        this.wrapper(delegate,operational,container));
            }
            logger.error("No Interfaces, very odd as it's an interface: " + delegateClass.getCanonicalName());
        }
        logger.error("ProxyDelegation is unable to create: " + delegateClass.getCanonicalName());
        throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed, this.getClass());
    }
    public abstract InvocationHandler wrapper(N delegate, O operational, T container);

    protected Class<?>[] getConnectionMemberInterfaces(Class<?> clazz)  {
        if (interfacesCache.containsKey(clazz.getCanonicalName())) {
            return interfacesCache.get(clazz.getCanonicalName());
        }
        List<Class<?>> classes = new ArrayList<>();
        classes.add(clazz);
        classes.addAll(Arrays.asList(clazz.getInterfaces()));
        classes.add(Wrapper.class);
        Class<?>[] classArray = classes.toArray( new Class[classes.size()]);
        interfacesCache.put(clazz.getCanonicalName(), classArray);
        return classArray;
    }
    protected Map<String, Class<?>[]> interfacesCache = new ConcurrentHashMap<>();
}
