package dev.inward.matrix.authority;

import dev.inward.matrix.Clerk;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.dns.resourceRecord.ResourceRecord;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Registrar<S extends Scheme<S,L>,L extends Library<S,L>>{

    protected final S scheme;

    public Registrar(S scheme) {
        this.scheme = scheme;
    }

    protected transient final Map<Clerk, Instant> clerksLastUsed = new ConcurrentHashMap<>();
    protected final Map<ResourceRecord, Instant> resourceRecordsLastUpdated = new ConcurrentHashMap<>();

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return null;
    }
}
