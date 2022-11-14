package dev.inward.matrix.policy;


public class ClockPolicy extends Policy<ClockPolicy> {

    public ClockPolicy(Clock clock) {
        super();
    }

    @Override
    protected Clock initDefault() {
        return null;
    }
}
