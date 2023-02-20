package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.Fact;

import java.time.Instant;
import java.util.UUID;

public abstract class Identity<I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<?,I,ID,X>> implements Comparable<I> {

    public static final char Aforementioned = '\u0000';

    protected final char signet;
    protected final ID id;

    public static class Versioned<A extends Authoritative<A,VERSION,V,ID,EXPIRE,G>,VERSION extends Comparable<VERSION>,V extends Versioned<A,VERSION,V,ID,X>,ID extends Comparable<ID>,X extends Governance<A,V,ID,X>> extends Identity<F,V,ID,X> {

        protected final VERSION version;

        public Versioned(char signet, ID id, VERSION version) {
            super(signet,id);
            this.version = version;
        }
        public VERSION getVersion() {
            return version;
        }
    }

    public Identity(char signet, ID id) {
        this.signet = signet;
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    public final X getContext() {
        return (X) this.getClass().getProtectionDomain();
    }

    public final ID getId() {
        return id;
    }

    public final char getSignet() {
        return signet;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(I that) {
        int isZero = ((X)this.getClass().getProtectionDomain()).compareTo((X)that.getClass().getProtectionDomain());
        if (isZero == 0) {
            isZero = this.id.compareTo(that.id);
        }
        return isZero;
    }


    public static class WebPage extends Identity<WebPage,String,Context.Path> {
        public WebPage(String name) {
            super('/',name);
        }

    }
    public static class Aforementioned extends Identity<Aforementioned,UUID,Context.Aforementioned> {

        public Aforementioned() {
            super(Aforementioned,UUID.randomUUID());
        }
        public Aforementioned(UUID uuid) {
            super(Aforementioned,uuid);
        }
    }

    public static class Dated extends Identity<Dated, UUID,Instant,Context.Ranged> {
        public Dated(, UUID uuid, Instant createDate) {
            super(persona,uuid,createDate);
        }
    }
    public static class SuperEgo extends Identity<SuperEgo,String,ConcurrentModer,Context.Path> {

        public SuperEgo(char persona, String name, ConcurrentModer concurrentModer) {
            super(persona, name, concurrentModer);
        }
    }
    public static final class Ego extends Identity<Ego,UUID,Instant, Governance.Ethereal> {

        public Ego(UUID uuid,Instant createInstant) {
            super(Empty,uuid,createInstant);
        }
        public Ego() {
            this(UUID.randomUUID(),Instant.now());
        }
        @Override
        @SuppressWarnings("all")
        public int compareTo(Ego that) {
            int isZero =  this.getContext().compareTo(that.getContext());
            if (isZero == 0) {
                    return this.id.compareTo(that.id);
            }
            return isZero;
        }
    }
    public static final class Ghost extends Identity<Ghost,String,VERSION,Governance.Ethereal>  {

        protected final String name;
        protected final Runtime.Version version;
        public Ghost(Governance.Ethereal ethereal) {
            super(Empty, ethereal);
        }
    }
    public static final Ghost Aforementioned = new Ego(Governance.Ethereal.Aforementioned);


}
