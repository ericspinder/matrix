package dev.inward.matrix.policy;


import dev.inward.matrix.Policy;

public class ClockPolicy extends Policy<ClockPolicy> {

    public ClockPolicy(Clock clock) {
        super();
    }

    @Override
    protected Clock initDefault() {
        return null;
    }
}
