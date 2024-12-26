package dev.inward.matrix;

public class Query {

    protected final Pair<?>[] pairs;

    protected final String[] anchors;

    public Query(Pair<?>[] pairs, String[] anchors) {
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
