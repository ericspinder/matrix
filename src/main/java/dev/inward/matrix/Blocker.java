package dev.inward.matrix;

import dev.inward.matrix.fact.matter.Exceptionally;
import dev.inward.matrix.fact.matter.Indicia;

import java.util.UUID;

public class Blocker extends RuntimeException implements Exceptionally {

    protected final Indicia<Blocker> indicia;
    protected final transient Context<?,?,?,?,?,?> context;

    public Blocker(Context<?,?,?,?,?,?> context, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(e);
        this.indicia = new Indicia(context.toString(), focus, severity,e.getClass());
        this.context = context;
    }
    public Blocker(String locus, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(e);
        this.indicia = new Indicia(locus, focus, severity,e.getClass());
        this.context = null;
    }

    @Override
    public UUID getId() {
        return null;
    }
    @Override
    public Context<?,?,?,?,?,?> getContext(Void nothing) {
        return this.context;
    }

    @Override
    public String getContext() {
        if (context != null) {
            return context.toString();
        }
        return "no context available";
    }

    @Override
    public Indicia<Blocker> getIndicia() {
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
