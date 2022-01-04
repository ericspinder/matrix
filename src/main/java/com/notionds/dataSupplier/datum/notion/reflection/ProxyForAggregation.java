package com.notionds.dataSupplier.datum.notion.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.aggregation.Accounting;
import com.notionds.dataSupplier.aggregation.InvokeAggregator;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.exceptions.NotionExceptionWrapper;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.reflect.Method;

public class ProxyForAggregation<N, O extends Operational<N,W,T>, W extends Datum<N,O,T>, T extends Container<N,O,W>, G extends InvokeAggregator, I extends InvokeInterceptor<N,O,W,T,G>> extends Proxy<N,O,W,T> {

    private final I invokeInterceptor;
    private String description = "No description";

    public ProxyForAggregation(N delegate, O operational, T container, I invokeInterceptor) {
        super(delegate, operational, container);
        this.invokeInterceptor = invokeInterceptor;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Accounting accounting = this.getInvokeInterceptor().startInvoke(m, args);
        try {
            switch (m.getName()) {
                case "getInvokeInterceptor":
                    return this.getInvokeInterceptor();
                case "getDescription":
                    return this.getDescription();
                case "setDescription":
                    if (args[0] instanceof String) {
                        this.setDescription((String)args[0]);
                        return Void.TYPE;
                    }
                    throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed, this.getClass());
            }
            return super.invoke(proxy, m, args);
        }
        catch (Throwable throwable) {
            if (accounting != null && throwable instanceof NotionExceptionWrapper) {
                this.getInvokeInterceptor().exception((NotionExceptionWrapper) throwable, this.description, m, accounting);
            }
            throw throwable;
        }
        finally {
            if (accounting != null) {
                if (args != null && args[0] != null && args[0] instanceof String) {
                    this.getInvokeInterceptor().endInvoke(m, (String)args[0], accounting);
                }
                else {
                    this.getInvokeInterceptor().endInvoke(m, description, accounting);
                }
            }
        }
    }

    public I getInvokeInterceptor() {
        return this.invokeInterceptor;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
