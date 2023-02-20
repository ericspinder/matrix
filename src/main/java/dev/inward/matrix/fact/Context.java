package dev.inward.matrix.fact;

import dev.inward.matrix.domain.Domain;
import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.tracked.Controller;
import dev.inward.matrix.fact.tracked.SelfSignedCert;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.personality.Personality;

import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.time.Instant;

public abstract class Context<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<F,I,ID,X>> extends ProtectionDomain implements Comparable<X> {

    protected final Zone zone;

    public Context(Variant variant, Personality personality,
                   Factory<F,I,ID,X> factory,
                   Tree[] trees, Zone zone) {
        super(variant,personality,factory, trees);
        this.zone = zone;
    }
    public static class Ranged extends Context<Ranged> {
        protected final Instant startDate;
        protected final Instant endDate;
        public Ranged(Variant  variant,
                      Personality personality,
                      Factory factory,
                      Tree[] trees, Domain domain, InternetClass internetClass, Zone zone, Instant startDate, Instant endDate) {
            super(variant,personality,factory, trees,domain, internetClass, zone);
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Instant getStartDate() {
            return startDate;
        }

        public Instant getEndDate() {
            return endDate;
        }
    }

    public static class Path<F extends Fact<F,I,ID,Path<F,I,ID>>,I extends Identity<I,ID,Path<F,I,ID>>,ID extends Comparable<ID>> extends Context<F,I,ID,Path<F,I,ID>> {

        protected final String path;

        public Path(Variant variant,
                    Personality personality,
                    Factory factory,
                    Tree[] trees, Domain domain, InternetClass testCode, Zone zone, String path) {
            super(variant,personality,factory, trees,domain,testCode,zone);
            this.path = path;
        }

        public String getPath() {
            return path;
        }

        @Override
        public int compareTo(Path that) {
            if (this.path == null && that == null) {
                return 0;
            }
            if (this.path == null) {
                return 1;
            }
            if (that.path == null) {
                return -1;
            }
            int isZero = this.path.compareTo(that.path);
            if (isZero == 0) {
                return super.compareTo(that);
            }
            return isZero;
        }
    }

    public static final CodeSource Aforementioned_codesource = new Controller.Matrix(new URL("file://",Variant.aforementioned, new java.net.URLStreamHandler()), new SelfSignedCert());
    public static  Governance.Ethereal Aforementioned = new Governance.Ethereal();


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

    public Zone getZone() {
        return zone;
    }

}
