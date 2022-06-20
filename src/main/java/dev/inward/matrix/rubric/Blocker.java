package dev.inward.matrix.rubric;

import dev.inward.matrix.matter.Topic;

public class Blocker extends RuntimeException implements Topical {

    protected final Topic topic;

    public Blocker(String locus, Topic.Focus focus, Topic.Severity severity, Exception e) {
        super(e);
        this.topic = new Topic(locus, focus, severity);
    }

    public Topic getTopic() {
        return topic;
    }

}
