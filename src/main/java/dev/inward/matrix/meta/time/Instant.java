package dev.inward.matrix.meta.time;

public class Instant<I extends Instant<I>> extends Date<java.time.Instant,I> {

    public Instant(String label, String description, String i18n) {
        super(label, description, i18n);
    }
}
