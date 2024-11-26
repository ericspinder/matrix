package dev.inward.matrix;

import dev.inward.matrix.fact.datum.Envoy;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.function.Function;

public interface Datum<DATUM,D extends Datum<DATUM,D,E,PR>, E extends Envoy<DATUM,D, E, PR>, PR extends Representitive<?,?,?,?,PR,?>> extends Watchable {

    E getWare();

    E setWare();

    @Override
    default WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    @Override
    default WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return null;
    }
    class Resource<DATUM,D extends Datum<DATUM,D,E,PR>, E extends Envoy<DATUM,D, E, PR>, PR extends Representitive<?,?,?,?,PR,?>> extends dev.inward.matrix.Resource<DATUM,E,PR> {

        /**
         * @param parent
         * @param className
         * @param warnOnTotal
         * @param hardLimit
         * @param graveDigger
         */
        public Resource(Representitive parent, String className, long warnOnTotal, long hardLimit, Function graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }
}
