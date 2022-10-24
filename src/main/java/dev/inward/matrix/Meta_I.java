package dev.inward.matrix;

public interface Meta_I<CLASS> {

    String getLabel();

    String getDescription();

    default String getI18n() {
        if (this.getClass().isAssignableFrom(Enum.class)) {
            return ((Enum) this).describeConstable().get().getClass().getCanonicalName();
        } else {
            return this.getClass().getCanonicalName();
        }
    }

    class Meta<CLASS> implements Meta_I<CLASS> {

        private String label;
        private String description;
        private String i18n;

        public Meta(String label, String description, String i18n) {
            this.label = label;
            this.description = description;
            this.i18n = i18n;
        }

        public String getLabel() {
            return label;
        }

        public String getDescription() {
            return description;
        }

        public String getI18n() {
            return i18n;
        }

    }
}
