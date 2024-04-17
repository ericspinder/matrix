package dev.inward.matrix.concept.matter.messaging;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.session.Session;

import java.time.Instant;
import java.util.UUID;

public abstract class Response<S extends Scheme<S,L>,L extends Library<S,L>,PAYLOAD,R extends Response<S,L,PAYLOAD,R>> extends Matter<S,L,R,Session<S,L>> {

    protected PAYLOAD payload;
    public Response(UUID uuid, CI topicId, Instant createInstant, Indicia indicia, PAYLOAD payload) {
        super(uuid, topicId, createInstant, indicia);
        this.payload = payload;
    }
}
