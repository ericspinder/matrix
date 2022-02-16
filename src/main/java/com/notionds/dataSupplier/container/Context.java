package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

import java.io.Serializable;


public abstract class Context<X extends Context<X>> implements Comparable<X>, Serializable {

    public static final class Production extends Context<Production> {

        public Production(Library library, String path) {
            super(library, path);
        }

        @Override
        public boolean isProduction() {
            return true;
        }
    }

    public static class Test extends Context<Test> {

        public Test(Library library, String path, String testName) {
            super(library, path);
        }

        @Override
        public boolean isProduction() {
            return false;
        }
    }
    public static final class Individual<H extends House<H>> extends Character<H> {

        public Individual(Library library, H house  ) {
            super(library,'@',house);
        }

        @Override
        public boolean isProduction() {
            return true;
        }
    }
    public static final class Official<H extends House<H>> extends Character<H> {

        public Official(Library library,H house) {
            super(library, '^', house);
        }

        @Override
        public boolean isProduction() {
            return true;
        }
    }

    public static final class Gathering extends Context<Gathering> {

        public Gathering(Library library) {
            super(library, null);
        }

        @Override
        public boolean isProduction() {
            return true;
        }
    }
    public static final class Panel extends Context<Panel> {

        public Panel(Library library) {
            super(library,null);
        }

        @Override
        public boolean isProduction() {
            return false;
        }
    }
    public static abstract class Character<H extends House<H>> extends Context<Character<H>> {

        private H house;
        public Character(Library library, char path, H house) {
            super(library, String.valueOf(path));
            this.house = house;
        }
    }
    protected final Library library;
    protected final String path;

    public Context(Library library, String path) {
        this.library = library;
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
    protected int compare2(X that) {
        if (this.path.equals(that.getPath())) {
            return this.library.compareTo(that.library);
        }
        return this.path.compareTo(that.getPath());
    }
    public abstract boolean isProduction();

    public String getPath() {
        return path;
    }
    public Library getLibrary() {
        return this.library;
    }

}

