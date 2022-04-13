package dev.inward.matrix.datum;

import dev.inward.matrix.backup.BackupSet.BackupSet;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.path.Path;
import dev.inward.matrix.datum.fact.test.Test;

import java.io.Serializable;

public abstract class Identity<I extends Identity<I,X>,X extends Context<X>> implements Comparable<I>, Serializable {

    public interface Addressable<I extends Identity<I,X>,X extends Context<X>> {
        I getId();
    }
    private final String name;
    private final X context;

    public Identity(String name, X context) {
        this.name = name;
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public X getContext() {
        return context;
    }

    @Override
    public int compareTo(I that) {
        if (this.context.equals(that.getContext())) {
            if (this.name.equals(that.getName())) {
                return 0;
            }
            return this.name.compareTo(that.getName());
        }
        return this.context.compareTo(that.getContext());
    }

    public static final class SuperEgo<X extends Context.Platform<X>> extends Identity<SuperEgo<X>,X> {

        public SuperEgo(X context) {
            super(null ,context);
        }
    }
    public static final class Ego<X extends Context.Platform<X>> extends Identity<Ego<X>,X> {

        public Ego(String name, X context) {
            super(name, context);
        }

    }
    public static class Id<X extends Path<X>> extends Identity<Id<X>,X> {

        public Id(String name, X context) {
            super(name, context);
        }

    }

    public static final class Production extends Id<Path.Nominal> {

        public Production(String name, Path.Nominal context) {
            super(name, context);
        }
    }
    public static final class Backup extends Id<Path.Nominal> {

        protected BackupSet backupSet;

        public Backup(String name, Path.Nominal context, BackupSet backupSet) {
            super(name, context);
            this.backupSet = backupSet;
        }
    }

    public static final class Integration<T extends Test<T,?,?,?,?,?,?>> extends Id<Path.Mock<T>> {

        public Integration(String name, Path.Mock<T> context) {
            super(name, context);
        }
    }
}
