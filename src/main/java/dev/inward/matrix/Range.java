package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Indicia;

import java.util.StringJoiner;

@SuppressWarnings("all")
public abstract class Range<PATH extends Comparable<PATH>> {

    public abstract boolean eval(PATH candidate);
    public abstract String toString();

    private Range() {}

    public final static class All<PATH extends Comparable<PATH>> extends Range<PATH> {

        public All() {}

        @Override
        public boolean eval(PATH candidate) {
            return true;
        }

        @Override
        public String toString() {
            return "";
        }

    }

    public final static class BelowPath<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH upperPath;

        public BelowPath(PATH upperPath) {
            this.upperPath = upperPath;
        }

        public PATH getUpperPath() {
            return upperPath;
        }

        @Override
        public boolean eval(PATH candidate) {
            return upperPath.compareTo(candidate) > 0;
        }

        @Override
        public String toString() {
            return upperPath.toString().intern();
        }
    }
    public final static class AbovePath<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH lowerPath;

        public AbovePath(PATH lowerPath) {
            this.lowerPath = lowerPath;
        }

        public PATH getLowerPath() {
            return lowerPath;
        }

        @Override
        public boolean eval(PATH candidate) {
            return candidate.compareTo(this.lowerPath) > 0;
        }

        @Override
        public String toString() {
            return lowerPath.toString().intern();
        }

    }
    public final static class BelowPath<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH higherPath;

        public BelowPath(PATH higherPath) {
            this.higherPath = higherPath;
        }

        public PATH getHigherPath() {
            return higherPath;
        }

        @Override
        public boolean eval(PATH canidate) {
            return canidate.compareTo(this.higherPath) > 0;
        }

        @Override
        public String toString() {
            return higherPath.toString().intern();
        }
    }
    public final static class BetweenPaths<PATH extends Comparable<PATH>> extends Range<PATH> {

        protected final PATH lowerPath;
        protected final PATH upperPath;

        public BetweenPaths(PATH lowerPath, PATH upperPath) {
            this.lowerPath = lowerPath;
            this.upperPath = upperPath;
        }

        public final PATH getLowerPath() {
            return this.lowerPath;
        }

        public final PATH getUpperPath() {
            return this.upperPath;
        }

        @Override
        public boolean eval(PATH candidate) {
            return (upperPath.compareTo(candidate) > 0);
        }

        @Override
        public String toString() {
            return this.upperPath.toString() + '_' + this.lowerPath.toString();
        }
    }
}
