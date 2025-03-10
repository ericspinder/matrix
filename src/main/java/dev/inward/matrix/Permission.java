/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.info.Agent;
import dev.inward.matrix.file.addressed.info.House;

import java.util.List;
import java.util.UUID;

public abstract class Permission<P extends Permission<P,SUBJECT>,SUBJECT> implements Addressed.Permit<P,SUBJECT> {

    protected final UUID uuid;
    protected final Agent owner;
    protected final House house;
    protected final List<Rule> rules;

    public Permission(UUID uuid, Agent owner, House house, List<Rule> rules) {
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
    public Agent getOwner() {
        return this.owner;
    }
    @Override
    public House getHouse() {
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
