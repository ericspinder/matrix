package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Exceptionally;
import dev.inward.matrix.concept.matter.Indicia;

import java.util.UUID;

public class Blocker extends RuntimeException implements Exceptionally {

    protected final Indicia indicia;

    public Blocker(String locus, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(e);
        this.indicia = new Indicia(locus, focus, severity,(short)0);
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public Indicia getIndicia() {
        return indicia;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return null;
    }

    @Override
    public String getMessage() {
        return indicia.toString();
    }
}
