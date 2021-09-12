package dev.inward.id;

import dev.inward.gathering.Gathering;

public class Id<A extends IdAgenda> {

    private final Gathering<A> gathering;

    public Id(Gathering<A> gathering) {
        this.gathering = gathering;
    }
}
