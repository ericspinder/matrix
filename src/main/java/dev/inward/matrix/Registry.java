package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.dns.resourceRecord.ResourceRecord;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Registry implements Comparable<Registry> {

    protected final UUID uuid;
    protected final Domain domain;

    protected final Map<Clerk.Network.Client, Intel<Clerk.Network.Client>> clientLastContact;
    protected final Map<ResourceRecord<?>, Intel<ResourceRecord<?>>> resourceRecordLastUpdate;
    protected final Map<Dogma<S,L,?>, AtomicStampedReference> userMap;


}
