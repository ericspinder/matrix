
/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

@SuppressWarnings("all")
public abstract class Range<PATH extends Comparable<PATH>> implements Comparable<Range<PATH>> {

    public static <PATH extends Comparable<PATH>> Range<PATH> Parse(PATH startPath, PATH endPath) {
        if (startPath == null && endPath == null) {
            return new AllPaths<>();
        }
        if (startPath == null) {
            return new BelowPath<>(endPath);
        }
        if (endPath == null) {
            return new AbovePath<>(startPath);
        }
        return new BetweenPaths<>(startPath, endPath);
    }

    /**
     *
     * @return the lowest PATH value, may be null.
     */
    abstract PATH getLowestPath();
    /**
     * @return a value which is 'just barely' higher than found in this range's paths but not inclusive in it, may be null.
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

    @Override
    public int compareTo(Range<PATH> that) {
        Integer thatInt = this.compare(that);
        if (thatInt != null) {
            return thatInt;
        }
        throw new RuntimeException("Cannot compare ranges: " + this.getClass().getCanonicalName() + " to " + that.getClass().getCanonicalName());
    }

    /**
     *
     * @param that
     * @return
     */
    public Integer compare(Range<PATH> that) {
        if (this instanceof Range.AllPaths<PATH>) {
            if (that instanceof Range.AllPaths<PATH>) {
                return 0;
            }
            else {
                return null;
            }
        }
        if (this instanceof Range.BelowPath<PATH>) {
            if (that instanceof Range.AbovePath<PATH> || that instanceof Range.BetweenPaths<PATH>) {
                int isZeroOrBetter = this.getHigherPath().compareTo(that.getLowestPath());
                if (isZeroOrBetter >= 0) {
                    return isZeroOrBetter;
                }
            }
            if (that instanceof Range.BelowPath<PATH> && that.getHigherPath().compareTo(this.getHigherPath())== 0) {
                return 0;
            }
            return null;
        }
        if (this instanceof Range.AbovePath<PATH>) {
            if (that instanceof Range.BelowPath<PATH> || that instanceof Range.BetweenPaths<PATH>) {
                int isZeroOrBetter = that.getLowestPath().compareTo(this.getLowestPath());
                if (isZeroOrBetter >= 0) {
                    return isZeroOrBetter;
                }
            }
            return null;
        }
        if (this instanceof Range.BetweenPaths<PATH>) {
            if (that instanceof Range.BetweenPaths<PATH>) {
                int isZeroOrBetter = this.getLowestPath().compareTo(that.getHigherPath());
                    // this may be higher
                if (isZeroOrBetter >= 0) {
                    isZeroOrBetter = this.getHigherPath().compareTo(that.getLowestPath());
                    if (isZeroOrBetter > 0) {
                        return isZeroOrBetter;
                    }
                }
                isZeroOrBetter = that.getLowestPath().compareTo(this.getHigherPath());
                if (isZeroOrBetter >= 0) {
                    // that may be higher
                    isZeroOrBetter = that.getHigherPath().compareTo(this.getLowestPath());
                    if (isZeroOrBetter >= 0) {
                        return isZeroOrBetter;
                    }
                }
                return null;
            }
            if (that instanceof Range.AbovePath<PATH>) {
                return this.getLowestPath().compareTo(that.getHigherPath());
            }
            if (that instanceof Range.BelowPath<PATH>) {
                return this.getHigherPath().compareTo(that.getLowestPath());
            }
        }
        return null;
    }

    public abstract String toString();

//    public static <S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>> Catalog<S,L,PATH> GetCatlogForRange(L library, URL url) {
//
//    }

    public final static class AllPaths<PATH extends Comparable<PATH>> extends Range<PATH> {

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
            return "";
        }

        @Override
        public int compareTo(Range<PATH> that) {
            return 0;
        }
    }
    public final static class BelowPath<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH higherPath;

        public BelowPath(PATH higherPath) {
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
            return "?higherPath=" + higherPath;
        }

    }
    public final static class AbovePath<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH lowestPath;

        public AbovePath(PATH lowestPath) {
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
            return "?lowestPath=" + lowestPath;
        }
    }
    public final static class BetweenPaths<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH lowestPath;
        protected final PATH higherPath;

        public BetweenPaths(PATH lowestPath, PATH higherPath) {
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
            return "?lowestPath=" + lowestPath + ",higherPath=" + higherPath;
        }
    }
}
