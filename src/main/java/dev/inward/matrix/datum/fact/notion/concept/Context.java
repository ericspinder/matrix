package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.fact.notion.authority.Authority;
import dev.inward.matrix.domain.InternetClass;

import java.util.Arrays;

public abstract class Context<X extends Context<X>> implements Comparable<X> {

    protected final InternetClass internetClass;
    protected Authority authority;

    public Context(Authority authority, InternetClass internetClass) {
        this.authority = authority;
        this.internetClass = internetClass;
    }

    public Authority getAuthority() {
        return authority;
    }

    public static class Service extends Context<Service> {

        protected final char[] index;

        public Service(Authority authority, InternetClass testCode, char[] index) {
            super(authority,testCode);
            this.index = index;
        }

        public char[] getIndex() {
            return index;
        }

        @Override
        public int compareTo(Service that) {
            if (this.index == null && that == null) {
                return 0;
            }
            if (this.index == null) {
                return 1;
            }
            if (that.index == null) {
                return -1;
            }
            int isZero = Arrays.compare(this.index, that.index);
            if (isZero == 0) {
                return super.compareTo(that);
            }
            return isZero;
        }
    }

    public static class Ethereal extends Context<Ethereal> {
        public Ethereal(Authority authority,InternetClass internetClass) {
            super(authority,internetClass);
        }
    }

    public int compareTo(X that) {
        if (this.authority == null && that.authority == null) {
            return this.internetClass.getAuthorityCode() - that.internetClass.getAuthorityCode();
        }
        if (this.authority == null) {
            return 1;
        }
        if (that.authority == null) {
            return -1;
        }
        int isZero = this.authority.compareTo(that.authority);
        if (isZero == 0) {
            return this.internetClass.getAuthorityCode() - that.internetClass.getAuthorityCode();
        }
        return isZero;
    }
}
