package dev.inward.matrix;

import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Criterion;

import java.net.URL;

public class Standard extends Concept<String, Standard.Pathway,String,Standard.Identity,Standard> {

    protected final String description;
    protected final URL transformerClassURL;
    protected final URL[] inductionClassURLs;
    protected final Criterion<?,?,?,?,?>[] demonCriteria;

    public Standard(final Identity identity, final String description, final URL transformerClassUrl, final URL[] inductionClassUrls, Criterion<?,?,?,?,?>[] demonCriteria) {
        super(identity);
        this.description = description;
        this.transformerClassURL = transformerClassUrl;
        this.inductionClassURLs = inductionClassUrls;
        this.demonCriteria = demonCriteria;
    }

    @Override
    public Dogma userInfo() {
        return null;
    }

    @Override
    public Ledger<String, Pathway> getLedger() {
        return null;
    }

    @Override
    public Pathway getDirectory() {
        return null;
    }

    @Override
    public int compareTo(Standard o) {
        return 0;
    }

    public static class Identity extends Tangible<String,Pathway,String,Identity,Standard> {

        public Identity(String s) {
            super(s);
        }

        @Override
        public String getId() {
            return null;
        }

        @Override
        public String getPath() {
            return null;
        }

        @Override
        public Standard get() {
            return null;
        }

        @Override
        public int compareTo(Identity o) {
            return 0;
        }
    }
    public static class Pathway extends dev.inward.matrix.Pathway<String,Pathway> {
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