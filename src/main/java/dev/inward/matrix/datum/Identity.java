package dev.inward.matrix.datum;

import dev.inward.matrix.backup.BackupSet.BackupSet;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.test.Test;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.path.Path;

import java.io.Serializable;
import java.util.UUID;

public abstract class Identity<I extends Identity<I,X>,X extends Context<X>> implements Comparable<I>, Serializable {

    public interface Addressable<T,I extends Identity<I,X>,X extends Context<X>> extends Comparable<T>, Serializable {
        I getId();
    }
    protected final String name;
    protected final X context;
    protected final Indicia indicia;

    public Identity(String name, X context, Indicia indicia) {
        this.name = name;
        this.context = context;
        this.indicia = indicia;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(I that) {
        if (this.context.equals(that.context)) {
            if (this.name.equals(that.getName())) {
                return 0;
            }
            return this.name.compareTo(that.getName());
        }
        return this.context.compareTo(that.context);
    }

    /**
     * Domain + any Characters
     * e.g. example.com*
     * e.g. example.comA
     * e.g. example.coma
     *
     */
    public static final class SuperEgo extends Identity<SuperEgo, Context.Service> {

        public SuperEgo(String name,Context.Service context, Indicia indicia) {
            super(name,context,indicia);
        }
    }

    /**
     * Domain + NULL
     */
    public static final class Ego extends Identity<Ego,Context.JVM> {

        public Ego(UUID uuid, Context.JVM context, Indicia indicia) {
            super(uuid.toString(),context,indicia);
        }

    }

    /**
     * Domain + Slash character
     * e.g.  example.com/index.html
     * @param <X>
     */
    public static class Id<X extends Path<X>> extends Identity<Id<X>,X> {

        public Id(String name,X context, Indicia indicia) {
            super(name,context,indicia);
        }

    }

    public static final class Production extends Id<Path.Nominal> {

        public Production(String name, Path.Nominal context, Indicia indicia) {
            super(name, context,indicia);
        }
    }
    public static final class Backup extends Id<Path.Nominal> {

        protected BackupSet backupSet;

        public Backup(String name, Path.Nominal context, Indicia indicia, BackupSet backupSet) {
            super(name, context,indicia);
            this.backupSet = backupSet;
        }
    }

    public static final class Integration<T extends Test<T,?,?,?,?,?,?>> extends Id<Path.Mock<T>> {

        public Integration(String name, Path.Mock<T> context, Indicia indicia) {
            super(name, context,indicia);
        }
    }
    public X getContext() {
        return this.context;
    }
}
