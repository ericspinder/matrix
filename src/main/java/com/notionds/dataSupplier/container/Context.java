package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;


public abstract class Context<H extends House<H,L>,L extends Library<H,L>,X extends Context<H,L,X>> implements Comparable<X>, Serializable {

    public static final class Production<H extends House<H,L>,L extends Library<H,L>> extends Context<H,L,Production<H,L>> {

        public Production(H house, String path) {
            super(house, path);
        }

        @Override
        public boolean isProduction() {
            return true;
        }
    }

    public static class Test<H extends House<H,L>,L extends Library<H,L>> extends Context<H,L,Test<H,L>> {

        public Test(H house, String path, String testName) {
            super(house, path);
        }

        @Override
        public boolean isProduction() {
            return false;
        }
    }
    public static final class Individual<H extends House<H,L>,L extends Library<H,L>> extends Context<H,L,Individual<H,L>> {

        public Individual(H house) {
            super(house, null);
        }

        @Override
        public boolean isProduction() {
            return false;
        }
    }
    private final House house;
    private final String path;
    public Context(H house, String path) {
        this.house = house;
        this.path = path;
    }

    @Override
    public int compareTo(X that) {
        if (this.isProduction() && that.isProduction()) {
            return compare2(that);
        }
        if (this.isProduction()) return 1;
        if (that.isProduction()) return -1;
        return compare2(that);
    }
    private int compare2(X that) {
        if (this.path.equals(that.getPath())) {
            return this.house.compareTo(that.getHouse());
        }
        return this.path.compareTo(that.getPath());
    }
    public abstract boolean isProduction();

    public String getPath() {
        return path;
    }
    public House getHouse() {
        return house;
    }

}

