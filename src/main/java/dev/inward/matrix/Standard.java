package dev.inward.matrix;

import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Operational;

public class Standard<O extends Operation<PATH,?,?,?,?,?>,PATH extends Comparable<PATH>> extends Addressed<String,String,Standard.Identity<O,PATH>,Standard<O,PATH>, Standard.Representitive<O,PATH>> {

    protected final String description;
    protected final Criterion[] demonCriteria;

    protected final Operational operational;

    public Standard(final Identity identity, final String description, Criterion[] demonCriteria,Operational operational) {
        super(identity);
        this.description = description;
        this.demonCriteria = demonCriteria;
        this.operational = operational;
    }

    public static class Identity extends dev.inward.matrix.Identity<String,String,Identity,Standard,> {

        public Identity(String s) {
            super(s);
        }

    }
    public static class Representitive<C extends Operation<String,String,Identity,Standard,C, Representitive<C>>> extends dev.inward.matrix.Representitive<String,String,Identity,Standard<C>,C,> {
        protected final String branch;
        public Pathway(Ledger<String, Pathway> ledger, String package_) {
            super(ledger, package_);
        }

        @Override
        public String getPathString() {
            return null;
        }
    }

    public Variant getVariant() {
        return variant;
    }

    public String getClassName() {
        return className;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getTransformerClassName() {
        return transformerClassName;
    }

    public String[] getInductionClassNames() {
        return inductionClassNames;
    }

    public Criterion[] getCriteria() {
        return criteria;
    }
}