package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.house.House;

import java.io.Serializable;

public abstract class Id<I extends Id<I,X>,X extends Context<X>> implements Comparable<I>, Serializable {

    public interface Addressable<I extends Id<I,X>,X extends Context<X>> {
        I getId();
    }
    private final String name;
    private final X context;

    public Id(String name, X context) {
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

    public static final class SuperEgo<H extends House<H>> extends Id<SuperEgo<H>,Context.Character<H>> {

        public SuperEgo(String id, Context.Character<H> context) {
            super(id,context);
        }
    }

    public static class Ego extends Id<Ego,Context.Gathering> {

        public Ego(String id, Context.Gathering context) {
            super(id, context);
        }
    }
    public static class Farce extends Id<Farce,Context.Panel> {

        public Farce(String name, Context.Panel context) {
            super(name, context);
        }

    }

    public static final class Data extends Id<Data,Context.Production> {

        public Data(String name, Context.Production context) {
            super(name, context);
        }
    }
    public static final class Satire extends Id<Satire,Context.Test> {

        public Satire(String name, Context.Test context) {
            super(name, context);
        }
    }
}
