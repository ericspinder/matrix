package dev.inward.matrix.rubric;

import dev.inward.matrix.matter.Indicia;

public class Roller extends Throwable {

    protected final Indicia indicia;

    public Roller(String locus, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(e);
        this.indicia = new Indicia(locus, focus, severity);
    }

    public Indicia getSubject() {
        return indicia;
    }
}
