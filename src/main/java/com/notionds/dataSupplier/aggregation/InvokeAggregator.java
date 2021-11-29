package com.notionds.dataSupplier.aggregation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

public abstract class InvokeAggregator implements EvictByLowCountMap.Member, Comparable {

    public static class Default_intoLog extends InvokeAggregator {

        private static final Logger logger = LogManager.getLogger();

        public Default_intoLog(Method method, String message) {
            super(method, message);
        }

        @Override
        public void addInvokeAccounting(Accounting accounting) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t").append(this.description).append(" : ");
            if (accounting.getDuration() != null) {
                stringBuilder.append("seconds=").append(accounting.getDuration().getSeconds()).append('.').append(accounting.getDuration().getNano());
            }
            else {

            }
            stringBuilder.append(" count=").append(count.incrementAndGet());
            logger.info(stringBuilder.toString());
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    protected AtomicLong count = new AtomicLong();
    protected final Method method;
    protected final String description;

    public InvokeAggregator(Method method, String description) {
        this.method = method;
        this.description = description;
    }

    public long getCount() {
        return this.count.get();
    }

    public void addInvokeAccounting(Accounting accounting) {
        this.count.incrementAndGet();

    }
}
