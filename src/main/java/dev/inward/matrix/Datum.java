package dev.inward.matrix;

import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.fact.datum.Envoy;

import java.io.IOException;
import java.lang.ref.Reference;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.function.Function;

public interface Datum<D extends Datum<D,E>, E extends Envoy<D,E>> extends Watchable {

    E getEnvoy();

    void setEnvoy(E envoy);

    @Override
    default Complication<?,D,?,?,?> register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    @Override
    default Complication<?,D,?,?,?> register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return null;
    }
    class Resource<DATUM,D extends Datum<DATUM,D,E>, E extends Envoy<DATUM,D,E>> extends dev.inward.matrix.Resource<DATUM,E> {

        /**
         * @param parent
         * @param className
         * @param warnOnTotal
         * @param hardLimit
         * @param graveDigger
         */
        public Resource(Representitive<?,?,?,?,?> parent, String className, long warnOnTotal, long hardLimit, Function<Reference<? extends DATUM>,Reference<? extends DATUM>> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }
}
