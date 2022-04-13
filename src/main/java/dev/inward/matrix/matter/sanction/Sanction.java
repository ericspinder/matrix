package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.matter.Matter;

import java.time.Instant;
import java.util.UUID;

public abstract class Sanction<Y extends Factory<Y,?,?,I,X,?,?>,I extends Identity<I,X>,X extends Context<X>,R extends Regulator<X>,S extends Sanction<Y,I,X,S>> extends Matter<I,X,S> {

    private final Subject Sanction = new Subject(this.getClass().getCanonicalName(), Subject.Focus.Regulatory, Subject.Severity.Privilege);
    private final Regulator<R> regulator;
    public Sanction(UUID uuid, I subjectId, Instant createInstant, Subject subject, Regulator<R> regulator) {
        super(uuid, subjectId, createInstant, subject);
        this.regulator = regulator;
    }

}
