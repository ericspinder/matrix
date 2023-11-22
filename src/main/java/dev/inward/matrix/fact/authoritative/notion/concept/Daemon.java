package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.Clerk;
import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.datum.Complication;
import dev.inward.matrix.phenomenon.Phenomenon;

import java.io.IOException;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Daemon implements WatchService {

    private final LinkedBlockingDeque<WatchKey> pendingKeys = new LinkedBlockingDeque<>();

    @Override
    public void close() throws IOException {

    }

    @Override
    public Clerk poll() {
        return null;
    }

    @Override
    public Clerk poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public Clerk take() throws InterruptedException {
        return null;
    }
}
