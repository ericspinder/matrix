package dev.inward.fact.session;

import dev.inward.crud.Create;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor

public abstract class SessionUpdate extends Crud<Session, Create> {

    public SessionUpdate(Engagement engagement, Comparable value) {
        super(engagement, value);
    }
}
