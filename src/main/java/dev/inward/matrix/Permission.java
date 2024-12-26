package dev.inward.matrix;

import java.util.List;
import java.util.UUID;

public abstract class Permission<P extends Permission<P,SUBJECT>,SUBJECT> implements Addressed.Permit<P,SUBJECT> {

    protected final UUID uuid;
    protected final Dogma.Agent owner;
    protected final Dogma.House house;
    protected final List<Rule> rules;

    public Permission(UUID uuid, Dogma.Agent owner, Dogma.House house, List<Rule> rules) {
        this.uuid = uuid;
        this.owner = owner;
        this.house = house;
        this.rules = rules;


    }
    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public Dogma.Agent getOwner() {
        return this.owner;
    }
    @Override
    public Dogma.House getHouse() {
        return this.house;
    }
    @Override
    public List<Rule> getRules() {
        return this.rules;
    }
    @Override
    public void notify(Addressed.Noted noted) {

    }
    @Override
    public void process(Exception exception) {

    }

    @Override
    public int compareTo(P o) {
        return 0;
    }
}
