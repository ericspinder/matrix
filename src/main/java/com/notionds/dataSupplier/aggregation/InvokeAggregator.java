package com.notionds.dataSupplier.aggregation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

public abstract class InvokeAggregator implements LowCountEviction.Member, Comparable {

    public static class Default_intoLog extends InvokeAggregator {

        private static final Logger logger = LogManager.getLogger();

        public Default_intoLog(Method method, String message) {
            super(method, message);
        }

        @Override
        public void addInvokeAccounting(Timer timer) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t").append(this.description).append(" : ");
            if (timer.getDuration() != null) {
                stringBuilder.append("seconds=").append(timer.getDuration().getSeconds()).append('.').append(timer.getDuration().getNano());
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

    public void addInvokeAccounting(Timer timer) {
        this.count.incrementAndGet();

    }
}
