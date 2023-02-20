package dev.inward.matrix.fact.matter.messaging;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.fact.Context;

import java.time.Instant;
import java.util.UUID;

public abstract class Advice<A extends Advice<A,IA,XA>,IA extends Identity<IA,XA>,XA extends Context<XA>> extends Matter<A,IA,XA> {


    public Advice(UUID uuid, IA topicId, Instant createInstant, Indicia indicia) {
        super(uuid, topicId, createInstant, indicia);
    }
}
