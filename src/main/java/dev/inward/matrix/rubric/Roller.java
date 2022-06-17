package dev.inward.matrix.rubric;

import dev.inward.matrix.matter.Topic;

public class Roller extends Throwable {

    protected final Topic topic;

    public Roller(String locus, Topic.Focus focus, Topic.Severity severity, Exception e) {
        super(e);
        this.topic = new Topic(locus, focus, severity);
    }

    public Topic getSubject() {
        return topic;
    }
}
