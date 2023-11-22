package dev.inward.matrix;

import dev.inward.matrix.fact.matter.Indicia;

import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

@SuppressWarnings("all")
public abstract class Range<VALUE extends Comparable<VALUE>> implements Comparable<Range<VALUE>> {

    public abstract boolean eval(VALUE candidate);
    public abstract String toString();

    private Range() {}

    public final static class All<VALUE extends Comparable<VALUE>> extends Range<VALUE> {

        public All() {}

        @Override
        public boolean eval(VALUE candidate) {
            return true;
        }

        @Override
        public String toString() {
            return "";
        }
    }

    public final static class BelowSingleValue<VALUE extends Comparable<VALUE>> extends Range<VALUE> {

        protected final VALUE upperValue;

        public BelowSingleValue(VALUE upperValue) {
            this.upperValue = upperValue;
        }

        public VALUE getUpperValue() {
            return upperValue;
        }

        @Override
        public boolean eval(VALUE candidate) {
            return upperValue.compareTo(candidate) > 0;
        }

        @Override
        public String toString() {
            return upperValue.toString().intern();
        }
    }
    public final static class AboveSingleValue<VALUE extends Comparable<VALUE>> extends Range<VALUE> {

        protected final VALUE lowerValue;

        public AboveSingleValue(VALUE lowerValue) {
            this.lowerValue = lowerValue;
        }

        public VALUE getLowerValue() {
            return lowerValue;
        }

        @Override
        public boolean eval(VALUE candidate) {
            return candidate.compareTo(lowerValue) > 0;
        }

        @Override
        public String toString() {
            return lowerValue.toString().intern();
        }
    }
    public final static class BetweenTwoValues<VALUE extends Comparable<VALUE>> extends Range<VALUE> {

        protected final VALUE lowerValue;
        protected final VALUE upperValue;
        protected final String joined;

        public BetweenTwoValues(VALUE lowerValue, VALUE upperValue) {
            this(lowerValue,upperValue,new StringJoiner("_"));
        }
        public BetweenTwoValues(VALUE lowerValue, VALUE upperValue, StringJoiner stringJoiner) {
            this.lowerValue = lowerValue;
            this.upperValue = upperValue;
            stringJoiner.add(lowerValue.toString()).add(upperValue.toString());
            this.joined = stringJoiner.toString();
        }

        public final VALUE getLowerValue() {
            return this.lowerValue;
        }

        public final VALUE getUpperValue() {
            return this.upperValue;
        }

        @Override
        public boolean eval(VALUE candidate) {
            return (upperValue.compareTo(candidate) > 0);
        }

        @Override
        public String toString() {
            return this.joined;
        }
    }

    @Override
    public int compareTo(Range<VALUE> that) {
        if (that instanceof Range.All) {
            if (this instanceof Range.All) {
                return 0;
            }
            if (this instanceof Range.AboveSingleValue) {
                return Integer.MIN_VALUE;
            }
            if (this instanceof Range.BelowSingleValue) {
                return Integer.MAX_VALUE;
            }
            if (this instanceof Range.BetweenTwoValues) {
                return 1;
            }
        }
        if (that instanceof Range.AboveSingleValue) {
            if (this instanceof Range.All) {
                return Integer.MIN_VALUE;
            }
            if (this instanceof Range.AboveSingleValue) {
               return ((AboveSingleValue<VALUE>) this).lowerValue.compareTo(((AboveSingleValue<VALUE>)that).lowerValue);
            }
            if (this instanceof Range.BelowSingleValue) {
                return ((BelowSingleValue<VALUE>) this).upperValue.compareTo(((AboveSingleValue<VALUE>)that).lowerValue);
            }
            if (this instanceof Range.BetweenTwoValues) {
                int isPositive = ((BetweenTwoValues<VALUE>) this).lowerValue.compareTo(((Range.AboveSingleValue<VALUE>)that).lowerValue);
                if (isPositive >= 0) {
                    return ((BetweenTwoValues<VALUE>) this).upperValue.compareTo(((AboveSingleValue<VALUE>)that).lowerValue);
                }
                return isPositive;
            }
        }
        if (that instanceof Range.BelowSingleValue) {
            if (this instanceof Range.All) {
                return Integer.MAX_VALUE;
            }
            if (this instanceof Range.AboveSingleValue) {
                return ((AboveSingleValue<VALUE>) this).lowerValue.compareTo(((BelowSingleValue<VALUE>)that).upperValue);
            }
            if (this instanceof Range.BelowSingleValue) {
                return ((BelowSingleValue<VALUE>) this).upperValue.compareTo(((BelowSingleValue<VALUE>)that).upperValue);
            }
            if (this instanceof Range.BetweenTwoValues) {
                int isPositive = ((BetweenTwoValues<VALUE>) this).lowerValue.compareTo(((BelowSingleValue<VALUE>)that).upperValue);
                if (isPositive >= 0) {
                    return ((BetweenTwoValues<VALUE>) this).upperValue.compareTo(((BelowSingleValue<VALUE>)that).upperValue);
                }
                return isPositive;
            }
        }
        if (that instanceof Range.BetweenTwoValues) {
            if (this instanceof Range.All) {
                return 0;
            }
            if (this instanceof Range.AboveSingleValue) {
                int isPositive =  ((AboveSingleValue<VALUE>) this).lowerValue.compareTo(((BetweenTwoValues<VALUE>)that).lowerValue);
                if (isPositive >= 0) {
                    return ((AboveSingleValue)this).lowerValue.compareTo(((BetweenTwoValues<VALUE>)that).upperValue);
                }
                return isPositive;
            }
            if (this instanceof Range.BelowSingleValue) {
                int isPositive = ((BelowSingleValue<VALUE>)this).upperValue.compareTo(((BetweenTwoValues<VALUE>)that).lowerValue);
                if (isPositive >= 0) {
                    return ((BelowSingleValue<VALUE>) this).upperValue.compareTo(((BetweenTwoValues<VALUE>)that).upperValue);
                }
                return isPositive;
            }
            if (this instanceof Range.BetweenTwoValues) {
                int isPositive = ((BetweenTwoValues<VALUE>) this).lowerValue.compareTo(((BetweenTwoValues<VALUE>)that).lowerValue);
                if (isPositive >= 0) {
                    return ((BetweenTwoValues<VALUE>) this).upperValue.compareTo(((BetweenTwoValues<VALUE>)that).upperValue);
                }
                return isPositive;
            }
        }
        throw new MatrixException(MatrixException.Type.Catalog_not_initialized,"Incomparable", Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,new Exception("Should never happen because of a private default constructor"));
    }
}
