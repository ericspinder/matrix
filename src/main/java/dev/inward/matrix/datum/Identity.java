package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.io.Serializable;
import java.util.UUID;

public abstract class Identity<I extends Identity<I,X>,X extends Context<X>> implements Comparable<I>, Serializable {

//    public interface Addressable<T,I extends Identity<I,X>,X extends Context<X>> extends Comparable<T>, Serializable {
//        I getId();
//    }
    protected final String name;
    protected final X context;

    public Identity(String name, X context) {
        this.name = name;
        this.context = context;
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

        public SuperEgo(String name,Context.Service context) {
            super(name,context);
        }
    }

    /**
     * Domain + NULL
     */
    public static final class Ego extends Identity<Ego, Context.Ethereal> {

        public Ego(UUID uuid, Context.Ethereal context) {
            super(uuid.toString(),context);
        }

    }
    /**
     * Domain + Slash character
     * e.g.  example.com/index.html
     * @param
     */
    public static final class Path extends Identity<Path, Context.Web> implements Comparable<Path>, Serializable {

        protected final String path;

        public Path(String name, Context.Web context, String path) {
            super(name,context);
            this.path = path;
        }
    }
}
