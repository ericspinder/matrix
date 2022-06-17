package dev.inward.matrix.matter;

import dev.inward.matrix.meta.Meta_I;

import java.io.Serializable;

public final class Topic implements Comparable<Topic>, Serializable {

    private final String locus;
    private final Focus focus;
    private final Severity severity;

    /**
     *
     * @param locus typically the canonical name of the Id, it should never be unique, but may only happen once or never.
     * @param focus the
     * @param severity
     */
    public Topic(String locus, Focus focus, Severity severity) {
        this.locus = locus;
        this.focus = focus;
        this.severity = severity;
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
    public enum Severity implements Meta_I<Severity,Severity> {
        Trace("trace","Asked for by a Super Ego"),
        Privilege("privilege","Demanded by a Super Ego"),
        Nominal("nominal","Normal operation"),
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
    public int compareTo(Topic that) {
        if (this.locus.equals(that.getLocus())) {
            if(this.focus.equals(that.getFocus())) {

            }
            return this.focus.compareTo(that.getFocus());
        }
        return this.locus.compareTo(that.locus);
    }
}
