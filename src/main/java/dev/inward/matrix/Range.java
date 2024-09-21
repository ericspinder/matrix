package dev.inward.matrix;

import dev.inward.matrix.fact.Addressed;

@SuppressWarnings("all")
public abstract class Range<PATH extends Comparable<PATH>> {
    /**
     *
     * @return the lowest PATH value, may be null.
     */
    abstract PATH getLowestPath();
    /**
     * @return a value which is higher than this range, may be null.
     */
    abstract PATH getHigherPath();
    /**
     *
     * @param candidate
     * @return true if the cantidate PATH exactly matches a the lowest path or is below (but not inclusive of) a the higherPath.
     */
    public final boolean eval(PATH candidate) {
        if (getLowestPath() != null) {
            if (!(candidate.compareTo(getLowestPath()) >=0)) {
                return false;
            }
        }
        if (getHigherPath() != null) {
            if (candidate.compareTo(getHigherPath()) < 0) {
                return false;
            }
        }
        return true;
    }
    public abstract String toString();

    public final static class AllPaths<PATH extends Comparable<PATH>> extends Range<PATH> {
        public AllPaths() {}

        @Override
        PATH getHigherPath() {
            return null;
        }
        @Override
        PATH getLowestPath() {
            return null;
        }
        @Override
        public String toString() {
            return "AllPaths";
        }
    }
    public final static class BelowPathway<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH higherPath;

        public BelowPathway(PATH higherPath) {
            this.higherPath = higherPath;
        }

        @Override
        PATH getHigherPath() {
            return higherPath;
        }
        @Override
        PATH getLowestPath() {
            return null;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("BelowPathway{");
            sb.append("higherPath=").append(higherPath);
            sb.append('}');
            return sb.toString();
        }
    }
    public final static class AbovePathway<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH lowestPath;

        public AbovePathway(PATH lowestPath) {
            this.lowestPath = lowestPath;
        }

        @Override
        PATH getLowestPath() {
            return lowestPath;
        }
        @Override
        PATH getHigherPath() {
            return null;
        }
        @Override
        public String toString() {
        final StringBuilder sb = new StringBuilder("AbovePathway{");
        sb.append("lowestPath=").append(lowestPath);
        sb.append('}');
        return sb.toString();
        }
    }
    public final static class BetweenPathways<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH lowestPath;
        protected final PATH higherPath;

        public BetweenPathways(PATH lowestPath,PATH higherPath) {
            this.lowestPath = lowestPath;
            this.higherPath = higherPath;
        }

        @Override
        PATH getLowestPath() {
            return this.lowestPath;
        }

        @Override
        PATH getHigherPath() {
            return this.higherPath;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("BetweenPathways{");
            sb.append("lowestPath=").append(lowestPath);
            sb.append(", higherPath=").append(higherPath);
            sb.append('}');
            return sb.toString();
        }
    }
}
