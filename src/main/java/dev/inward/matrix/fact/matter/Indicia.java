package dev.inward.matrix.fact.matter;

import dev.inward.matrix.Meta_I;

import java.io.Serializable;

public final class Indicia implements Comparable<Indicia>, Serializable {

    private final String locus;
    private final Focus focus;
    private final Severity severity;
    private final char authorityCode;

    /**
     *
     * @param locus typically the canonical name of the Id, it should never be unique, but may only happen once or never.
     * @param focus the
     * @param severity
     */
    public Indicia(String locus, Focus focus, Severity severity, char authorityCode) {
        this.locus = locus;
        this.focus = focus;
        this.severity = severity;
        this.authorityCode = authorityCode;
    }
    public enum Focus implements Meta_I<Focus,Focus> {
        Assembly("assembly", "The matter is related to assembly for the Id on the platform"),
        Genesis("genesis", "The creation of the Id"),
        Change("change", "Change is afoot for the Id"),
        Disassembly("disassembly", "related to the disassembly for the Id on the platform"),
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
    public Focus getFocus() {
        return focus;
    }
    public String getLocus() {
        return locus;
    }
    public char getAuthorityCode() {
        return this.authorityCode;
    }
    public enum Severity implements Meta_I<Severity,Severity> {
        Critical("critical","Code related problem of primary importance"),
        Trace("trace","Asked for by a Super Ego"),
        Privilege("privilege","Demanded by a Super Ego"),
        Capacity("Capacity", "Capacity has been exceeded"),
        Nominal("nominal","Normal operation"),
        Timer("timer",""),
        Exceptional("exceptional","Problem"),
        Unexpected("unexpected", "represents a code guard on recursion which could get out of hand")
        ;
        private final String label;
        private final String description;

        Severity(String label, String description) {
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
    @Override
    public int compareTo(Indicia that) {
        int isZero = this.authorityCode - that.authorityCode;
        if (isZero == 0) {
            isZero = this.severity.compareTo(that.severity);
            if (isZero == 0) {
                isZero = this.focus.compareTo(that.focus);
                if (isZero == 0) {
                    return this.locus.compareTo(that.locus);
                }
            }
        }
        return isZero;
    }
}
