package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.Concept;

public abstract class Matrix extends Concept<String,Matrix.Pathway,String,Matrix.Id,Matrix> {

    public static class Pathway extends dev.inward.matrix.Pathway<String,Matrix.Pathway> {

        protected final String branch;
        public Pathway(Ledger<String, Pathway> ledger, String s, String branch) {
            super(ledger, s);
            this.branch = branch;
        }

        @Override
        public String getPathString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.branch != null && !this.branch.isBlank()) {
                stringBuilder.append('/').append(this.branch).append('/');
            }
        }
    }
    public static class Id extends Identity<String,Pathway,String,Id,Matrix> {

        public Id(String s) {
            super(s);
        }

    }

    public Matrix(Matrix.Id id) {
        super(id);
    }

}
