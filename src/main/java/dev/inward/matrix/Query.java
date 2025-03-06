/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

public class Query {

    protected final String username;
    protected final Pair<?>[] pairs;
    protected final String[] anchors;

    public Query(String username, Pair<?>[] pairs, String[] anchors) {
        this.username = username;
        this.pairs = pairs;
        this.anchors = anchors;
    }

    public record Pair<VALUE>(Aspect aspect, VALUE value) implements Comparable<Pair<?>> {

        @Override
        public int compareTo(Pair<?> that) {
            return this.aspect.compareTo(that.aspect);
        }
    }

    public Pair<?>[] getPairs() {
        return pairs;
    }

    public String[] getAnchors() {
        return anchors;
    }
}
