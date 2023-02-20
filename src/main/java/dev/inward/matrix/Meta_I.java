package dev.inward.matrix;

public interface Meta_I {

    String getLabel();
    String getDescription();

    default String getClassName() {
        return this.getClass().isAssignableFrom(Enum.class)?((Enum)this).describeConstable().get().getClass().getCanonicalName(): this.getClass().getCanonicalName();
    }
    default String getI18n() {
        if (this.getLabel() == null) {
            return getClassName() + ".label_value_NULL";
        }
        return getClassName() + '.' + getLabel();
    }

}
