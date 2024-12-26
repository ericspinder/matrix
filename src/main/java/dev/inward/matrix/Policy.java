package dev.inward.matrix;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;



public abstract class Policy<PATH extends Comparable<PATH>,K extends FileKey<PATH,K>,OCCURRENCE extends Comparable<OCCURRENCE>> implements Function<K, OCCURRENCE> {

    public abstract static class Design implements Meta_I {

        /**
         *
         * @return  less than zero - don't do again, not a damon
         *          zero - no wait damon, do again immediately
         *          more than zero - number of TimeUnit values to wait before looping, default is seconds.
         */
        public abstract int getDamonSleep();
        public abstract int getThreadCount();
        public TimeUnit getDamonTimeUnit() {
            return TimeUnit.SECONDS;
        }
        public boolean isDamon() {
            return getDamonSleep() > 0;
        }
        public boolean isSingleton() {
            return getThreadCount() == 1;
        }

        @Override
        public String getLabel() {
            return "Anonymous Design";
        }

        @Override
        public String getDescription() {
            return ((isDamon())?"Damon Sleep: " + getDamonSleep() + getDamonTimeUnit().toString():"Not a Damon") + ", Thread count: " + getThreadCount();
        }

        public static class SuperSingleton extends Design {

            @Override
            public int getDamonSleep() {
                return -1;
            }

            @Override
            public int getThreadCount() {
                return 1;
            }

            @Override
            public String getLabel() {
                return "Super Singleton";
            }

            @Override
            public String getDescription() {
                return "Not a Damon, Single thread";
            }
        }
    }
    protected final L library;
    protected final Design design;


    public Policy(L library, Design design) {
        this.library = library;
        this.design = design;
    }

    public L getLibrary() {
        return this.library;
    }

    public Design getDesign() {
        return design;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return this.getClass().getCanonicalName().compareTo(o.getClass().getCanonicalName()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass().getCanonicalName());
    }

}
