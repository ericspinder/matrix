package dev.inward.matrix.log;

import dev.inward.matrix.Meta_I;

import javax.annotation.Nonnull;
import java.nio.file.WatchEvent;
import java.util.Arrays;
import java.util.Objects;

public final class Indicia implements Comparable<Indicia>, WatchEvent.Kind<Indicia> {
    private final String terrine;
    private final String locus;
    private final Focus focus;
    private final Severity severity;
    private final short series;


    public Indicia(@Nonnull String terrine, @Nonnull String locus, @Nonnull Focus focus, @Nonnull Severity severity, short series, String complicationClassName, String complicationCriterionClassName, String providerClassName, String providerCriterionClassName, String supplierClassName, String supplierCriterionClassName, String policyClassName, String policyCriterionClassName, String dateTimeFormaterClassName, String[] defaultIndexClassNames) {
        this.terrine = terrine;
        this.locus = locus;
        this.focus = focus;
        this.severity = severity;
        this.series = series;

    }


    @Override
    public String name() {
        return this.locus;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Indicia> type() {
        return (Class<Indicia>) this.getClass();
    }


    public enum Focus implements Meta_I {
        Assembly("assembly", "The matter is related to assembly for the Id on the platform"),
        Genesis("genesis", "The creation of the Id"),
        Change("change", "Change is afoot for the Id"),
        View("view", "Reading values"),
        Disassembly("disassembly", "related to the disassembly"),
        Monitory("monitory", "monitoring relating to the Id"),
        Regulatory("regulatory", ""),
        Evaluation("evaluation", "evaluation of the Id"),
        Admonitory("admonitory", "The Id is reported to be exceptional"),
        Type("type", "Focus is integral to code of the type of the Id"),
        ;
        private final String label;
        private final String description;

        Focus(final String label, final String description) {
            this.label = label;
            this.description = description;
        }

        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    public enum Severity implements Meta_I {
        Critical("critical", "Code related problem of primary importance"),
        Trace("trace", "Asked for by Owner", 1000),
        Privilege("privilege", "Demanded by a Super Ego", 10),
        Capacity("Capacity", "Capacity has been exceeded", 200),
        Nominal("nominal", "Normal operation", 1000),
        Timer("timer", "Something which affects normal operation of a timer"),
        Exceptional("exceptional", "Problem"),
        Unexpected("unexpected", "experimental, represents a code guard which has not yet been grouped");
        private final String label;
        private final String description;
        protected final long autoSettleCount;

        Severity(String label, String description) {
            this(label, description, 1);
        }

        Severity(String label, String description, long autoSettleCount) {
            this.label = label;
            this.description = description;
            this.autoSettleCount = autoSettleCount;
        }

        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getDescription() {
            return description;
        }

        public long getAutoSettleCount() {
            return autoSettleCount;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indicia indicia = (Indicia) o;
        return series == indicia.series && locus.equals(indicia.locus) && focus == indicia.focus && severity == indicia.severity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locus, focus, severity, series);
    }

    @Override
    public int compareTo(Indicia that) {
        int isZero = this.locus.compareTo(that.locus);
        if (isZero == 0) {
            isZero = this.focus.compareTo(that.focus);
            if (isZero == 0) {
                return this.severity.compareTo(that.severity);
            }
        }
        return isZero;
    }

    @Override
    public String toString() {
        return "Indicia{" + "terrine='" + terrine + '\'' +
                ", locus='" + locus + '\'' +
                ", focus=" + focus +
                ", severity=" + severity +
                ", series=" + series +
                ", complicationClassName='" + complicationClassName + '\'' +
                ", complicationCriterionClassName='" + complicationCriterionClassName + '\'' +
                ", providerClassName='" + providerClassName + '\'' +
                ", providerCriterionClassName='" + providerCriterionClassName + '\'' +
                ", supplierClassName='" + supplierClassName + '\'' +
                ", supplierCriterionClassName='" + supplierCriterionClassName + '\'' +
                ", policyClassName='" + policyClassName + '\'' +
                ", policyCriterionClassName='" + policyCriterionClassName + '\'' +
                ", defaultIndexClassNames=" + Arrays.toString(defaultIndexClassNames) +
                '}';
    }

    public String terrine() {
        return terrine;
    }

    public String locus() {
        return locus;
    }

    public Focus focus() {
        return focus;
    }

    public Severity severity() {
        return severity;
    }

    public short series() {
        return series;
    }

    public String complicationClassName() {
        return complicationClassName;
    }

    public String complicationCriterionClassName() {
        return complicationCriterionClassName;
    }

    public String providerClassName() {
        return providerClassName;
    }

    public String providerCriterionClassName() {
        return providerCriterionClassName;
    }

    public String supplierClassName() {
        return supplierClassName;
    }

    public String supplierCriterionClassName() {
        return supplierCriterionClassName;
    }

    public String policyClassName() {
        return policyClassName;
    }

    public String policyCriterionClassName() {
        return policyCriterionClassName;
    }

    public String[] defaultIndexClassNames() {
        return defaultIndexClassNames;
    }

}
