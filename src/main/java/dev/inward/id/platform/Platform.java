package dev.inward.id.platform;

import dev.inward.gathering.Gathering;
import dev.inward.id.Id;

public class Platform<A extends PlatformAgenda> extends Id<A> {

    public Platform(Gathering<A> gathering) {
        super(gathering);
    }
}
