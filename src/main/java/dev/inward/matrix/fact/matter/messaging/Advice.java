package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.matter.Indicia;

import java.time.Instant;
import java.util.UUID;

public abstract class Advice<A extends Advice<A,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Matter<A,IA,XA> {


    public Advice(UUID uuid, IA topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
