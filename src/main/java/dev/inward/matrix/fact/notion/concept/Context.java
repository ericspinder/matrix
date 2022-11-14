package dev.inward.matrix.fact.notion.concept;

import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.engine.Zone;

import java.util.Arrays;

public abstract class Context<X extends Context<X>> implements Comparable<X> {

    protected final InternetClass internetClass;
    protected final Domain domain;
    protected final Zone zone;

    public Context(Domain domain, InternetClass internetClass, Zone zone) {
        this.domain = domain;
        this.internetClass = internetClass;
        this.zone = zone;
    }

    public Domain getDomain() {
        return domain;
    }

    public InternetClass getInternetClass() {
        return internetClass;
    }

    public static class Service extends Context<Service> {

        protected final char[] index;

        public Service(Domain domain, InternetClass testCode, Zone zone, char[] index) {
            super(domain,testCode,zone);
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
        public Ethereal(Domain domain,InternetClass internetClass,Zone zone) {
            super(domain,internetClass,zone);
        }
    }

    public int compareTo(X that) {
        if (this.domain == null && that.domain == null) {
            return this.internetClass.getAuthorityCode() - that.internetClass.getAuthorityCode();
        }
        if (this.domain == null) {
            return 1;
        }
        if (that.domain == null) {
            return -1;
        }
        int isZero = this.domain.compareTo(that.domain);
        if (isZero == 0) {
            return this.internetClass.getAuthorityCode() - that.internetClass.getAuthorityCode();
        }
        return isZero;
    }
}
