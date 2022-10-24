package crud.rubric;

import dev.inward.matrix.matter.Indicia;

public class Blocker extends RuntimeException implements Topical {

    protected final Indicia indicia;

    public Blocker(String locus, Indicia.Focus focus, Indicia.Severity severity, Exception e) {
        super(e);
        this.indicia = new Indicia(locus, focus, severity);
    }

    public Indicia getTopic() {
        return indicia;
    }

}
