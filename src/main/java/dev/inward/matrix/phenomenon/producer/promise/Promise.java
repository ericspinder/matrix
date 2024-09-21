package dev.inward.matrix.phenomenon.producer.promise;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.messaging.Request;
import dev.inward.matrix.concept.matter.messaging.Response;
import dev.inward.matrix.Context;
import dev.inward.matrix.phenomenon.producer.Producer;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public abstract class Promise<P extends Promise<P,RESP,REQ, CI, CX>,RESP extends Response<?,RESP, CI, CX>,REQ extends Request<REQ, CI, CX>, CI extends Identity<CI, CX>, CX extends Context<CX>> extends Producer<RESP,P,CI,CX> {

    protected final Instant instantExpectedReady;
    protected final Duration durationAvailable;

    public Promise(UUID uuid, CI requestedId, Instant createInstant, Indicia indicia, Instant instantExpectedReady, Duration durationAvailable) {
        super(uuid, requestedId, createInstant, indicia);
        this.instantExpectedReady = instantExpectedReady;
        this.durationAvailable = durationAvailable;
    }

    public final Instant getInstantExpectedReady() {
        return instantExpectedReady;
    }

    public final Duration getDurationAvailable() {
        return durationAvailable;
    }

}