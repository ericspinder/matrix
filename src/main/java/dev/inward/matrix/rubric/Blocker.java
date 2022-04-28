package dev.inward.matrix.rubric;

import dev.inward.matrix.matter.Subject;

public class Blocker extends RuntimeException implements Subjected {

    protected final Subject subject;

    public Blocker(String locus, Subject.Focus focus, Subject.Severity severity, Exception e) {
        super(e);
        this.subject = new Subject(locus, focus, severity);
    }

    public Subject getSubject() {
        return subject;
    }

}
