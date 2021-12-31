package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.meta.Meta_I;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.options.Options;
import com.notionds.dataSupplier.provider.Provider;
import com.notionds.dataSupplier.task.Task;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Factory<DATUM extends Comparable<DATUM> & Serializable,O extends Options<DATUM,O,D>,D extends Datum<DATUM,O,?,D,B>,B extends Bus<DATUM,O,?,D,B,?,?,M>,M extends Meta<DATUM,O,?,D,B>> {

    private Map<String, Bus<DATUM,?,?,?,?,N,?,?,?>> busRoutes = new ConcurrentHashMap<>();
    private O options;

    public Factory(O options, LinkedBlockingDeque<Provider<N,O,B,?,?>> providers) {
        this.options = options;
    }
    public <N, W extends Datum<N,?, I>, I extends Container<N,?,W>> void addProvider(LinkedBlockingDeque<Provider<N>> notionSuppliers) {

    }
    public <N, W extends Datum<N,?,T>,T extends Container<N,?,W>> W wrap(N delegate, Class<N> delegateClass, Object[] args) {
        if (this.busRoutes.containsKey(delegateClass.getCanonicalName())) {
            Bus<?,?,?,?,?,?,?,?,?,?> bus = this.busRoutes.get(delegateClass.getCanonicalName());
            Task[] tasks = new Task[]{bus.operational.};
            return bus.wrap(delegate,args, )
        }
        throw new NotionStartupException(NotionStartupException.Type.SoftReference_Problem, this.getClass());
    }

    private static class Default_JMX {

            public static Default_JMX INSTANCE = new Default_JMX();

            protected Map<String, Supplier<?>> getterSupplierList = new HashMap<>();
            protected Map<String, Consumer<?>> setterConsumerList = new HashMap<>();
            protected Map<String, Function<?,?>> functionMap = new HashMap<>();

//            private MBeanInfo mBeanInfo = null;
            public Default_JMX() {
                    super();

            }

//            @Override
//            protected void initialize(String instanceName) {
//                    List<MBeanAttributeInfo> attributeList = new ArrayList<>();
//                    /**
//                     * The max time a connection will be allowed to stay active.
//                     */
//                    attributeList.add(new MBeanAttributeInfo("maxConnectionLifetime", "java.lang.Integer", "The max time a connection will be allowed to stay active.", true, true, false));
//                    this.getterSupplierList.put("maxConnectionLifetime", maxConnectionLifetime_getter);
//                    this.setterConsumerList.put("maxConnectionLifetime", maxConnectionLifetime_setter);
//                    /**
//                     * Default timeout when loaned out
//                     */
//                    attributeList.add(new MBeanAttributeInfo("timeOnLoan", "java.lang.Duration", "Default timeout when loaned out", true, true, false));
//                    this.getterSupplierList.put("timeOnLoan", timeOnLoan_getter);
//                    this.setterConsumerList.put("timeOnLoan", timeOnLoan_setter);
//                    /**
//                     * Duration split into TimeUnits for efficient use in the poll method
//                     */
//                    attributeList.add(new MBeanAttributeInfo("connectionRetrieve", "java.lang.Duration", "Duration split into TimeUnits for efficient use in the poll method", true, true, false));
//                    this.getterSupplierList.put("connectionRetrieve", connectionRetrieve_getter);
//                    this.setterConsumerList.put("connectionRetrieve", connectionRetrieve_setter);
//                    attributeList.add(new MBeanAttributeInfo("maxTotalAllowedConnections", "java.lang.Integer", "Max number of connections allowed, this is not a hard limit", true, false, false));
//                    this.getterSupplierList.put("maxTotalAllowedConnections", maxTotalAllowedConnections_getter);
//                    this.setterConsumerList.put("maxTotalAllowedConnections", maxTotalAllowedConnections_setter);
//                    /**
//                     * The number of connections the system will attempt to keep in absence of breaching the maximum
//                     */
//                    attributeList.add(new MBeanAttributeInfo("minActiveConnections", "java.lang.Integer", "The number of connections the system will attempt to keep in absence of breaching the maximum", true, false, false));
//                    this.getterSupplierList.put("minActiveConnections", minActiveConnections_getter);
//                    this.setterConsumerList.put("minActiveConnections", minActiveConnections_setter);
//                    /**
//                     * Load the next
//                     */
//
//                    mBeanInfo = new MBeanInfo(instanceName, "Notion Data Source Management Interface", attributeList.toArray(new MBeanAttributeInfo[attributeList.size()]), null, null, null);
//            }
//
//            public MBeanInfo getMBeanInfo() {
//                    if (mBeanInfo == null) {
//                            initialize(this.getClass().getCanonicalName());
//                    }
//                    return mBeanInfo;
//
//            }
    }
}
