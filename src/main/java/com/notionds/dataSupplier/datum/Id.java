package com.notionds.dataSupplier.datum;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;

public abstract class Id<H extends House<H,L>,L extends Library<H,L>,I extends Id<H,L,I,X>,X extends Context<H,L,X>> implements Comparable<I>, Serializable {

    public static class Production<H extends House<H,L>,L extends Library<H,L>> extends Id<H,L,Production<H,L>,Context.Production<H,L>> {

        public Production(String name, Context.Production<H,L> context) {
            super(name, context);
        }
    }
    public static class Test<H extends House<H,L>,L extends Library<H,L>> extends Id<H,L,Test<H,L>,Context.Test<H,L>> {

        public Test(String name, Context.Test<H,L> context) {
            super(name, context);
        }
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
}
