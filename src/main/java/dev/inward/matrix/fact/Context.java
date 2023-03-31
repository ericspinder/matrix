package dev.inward.matrix.fact;

import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.authoritative.Reaper;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.fact.authoritative.yard.Tree;
import dev.inward.matrix.personality.Personality;

import java.security.ProtectionDomain;
import java.time.Instant;

public abstract class Context<X extends Context<X>> extends ProtectionDomain implements Comparable<X> {

    protected final Zone zone;

    public Context(Variant variant, Personality personality,
                   Industry industry,
                   Tree[] trees, Zone zone) {
        super(variant,personality,industry, trees);
        this.zone = zone;
    }
    public static class Ranged extends Context<Ranged> {
        protected final Instant startDate;
        protected final Instant endDate;
        public Ranged(Variant  variant,
                      Personality personality,
                      Industry industry,
                      Tree[] trees, Zone zone, Instant startDate, Instant endDate) {
            super(variant,personality,industry, trees, zone);
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Instant getStartDate() {
            return startDate;
        }

        public Instant getEndDate() {
            return endDate;
        }

        @Override
        public int compareTo(Ranged that) {
            int isZero = this.endDate.compareTo(that.endDate);
            if (isZero == 0) {
                isZero = this.startDate.compareTo(that.endDate);
            }
            return isZero;
        }
    }

    public static class Path extends Context<Path> {

        protected final String path;

        public Path(Variant variant,
                    Personality personality,
                    Industry industry,
                    Tree[] trees, Zone zone, String path) {
            super(variant,personality,industry,trees,zone);
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
            return isZero;
        }
    }
    public static Ethereal Aforementioned = new Ethereal();

    public Zone getZone() {
        return zone;
    }

    public static class Ethereal extends Context<Ethereal> {

        public Ethereal(Variant variant,
                        Personality personality,
                        Industry industry,
                        Tree[] trees, Zone zone) {
            super(variant, personality, industry, trees, zone);
        }

        @Override
        public int compareTo(Ethereal that) {

        }
    }

    public abstract static class Governance<EXPIRE extends Comparable<EXPIRE>,G extends Governance<EXPIRE,G>> extends Context<G> {

       protected final Reaper<EXPIRE,?,?> reaper;

       public Governance(Variant variant, Personality personality, Industry industry, Tree[] trees, Zone zone,Reaper<EXPIRE,?,?> reaper) {
           super(variant, personality, industry, trees, zone);
           this.reaper = reaper;
       }

    }
}
