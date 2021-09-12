package dev.inward.gathering;

import dev.inward.Fact;

import java.util.HashMap;
import java.util.Map;

public abstract class Agenda<T extends Topic> {

    private final Map<? super T, ? super Fact> knownTopics = new HashMap<>();

    public Fact get(T topic) {

    }
}
