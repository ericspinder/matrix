package dev.inward.matrix.personality;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.security.Permission;
import java.security.PermissionCollection;
import java.time.Instant;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class Personality<N extends Notion<N,I,X,A>,I extends Identity<I,X>,X extends Context<X>,A extends Agent<N,I,X,A>> extends PermissionCollection {

    private List<Psyche> psycheList;
    @Override
    public void add(Permission permission) {
        if (permission instanceof Psyche) {
            this.psycheList.add((Psyche)permission);
        }
    }

    @Override
    public boolean implies(Permission permission) {
        if (permission instanceof Psyche) {
            return psycheList.stream().anyMatch(i -> i.getName().equals(permission.getName()));
        }
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return null;
    }
}
