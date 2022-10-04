package crud;

public abstract class Meta<DATUM,M extends Meta<DATUM,M>> implements Meta_I<DATUM,M> {

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
