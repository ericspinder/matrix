package dev.inward.matrix.director.library.catalog;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.Dogma;

import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.StampedLock;

public abstract class Gathering<PATH extends Comparable<PATH>,P extends Pathway<PATH,P,CAT>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>,CAT extends Catalog<PATH,P,CAT>> {

    public static abstract class Meta<PATH extends Comparable<PATH>,P extends Pathway<PATH,P,CAT>,ID extends Comparable<ID>,T extends Concept.Tangible<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>,CAT extends Catalog<PATH,P,CAT>> implements AclFileAttributeView, BasicFileAttributeView {

        protected Administration<PATH,P,ID,T,C,CAT> administration;
        protected AtomicLong size;

        public Meta(Administration<PATH,P,ID,T,C,CAT> administration) {
            this.administration = administration;
        }

        public Administration<PATH, P, ID, T, C, CAT> getAdministration() {
            return administration;
        }

        public void setAdministration(Administration<PATH, P, ID, T, C, CAT> administration) {
            this.administration = administration;
        }

        @Override
        public Dogma.Agent getOwner() {
            return this.administration.getOwner();
        }
        @Override
        public List<AclEntry> getAcl() {
            return Arrays.asList(this.administration.getAclEntries());
        }
        @Override
        public abstract BasicFileAttributes readAttributes();

        public long getSize() {
            return this.size.get();
        }
        public long add(long add) {
            return this.size.addAndGet(add);
        }
        public long subtract(long subtract) {
            return this.size.decrementAndGet();
        }

        public abstract Instant lastAccess();
        public abstract Instant lastSync();

    }
    private transient final StampedLock gate = new StampedLock();

    protected final P pathway;
    protected final CAT catalog;
    protected final Map<C, Meta> concepts = new ConcurrentHashMap<>();

    public Gathering(Dogma.Agent owner, P pathway, CAT catalog, Map<C,Meta> conceptInitialize) {
        this.pathway = pathway;
        this.catalog = catalog;
        this.concepts.putAll(conceptInitialize);
    }

    protected final Map<C,Meta> getConcepts() {
        return this.concepts;
    }

    public CAT getCatalog() {
        return catalog;
    }

}
