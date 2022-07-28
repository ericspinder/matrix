package dev.inward.matrix.matter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;

import java.lang.ref.SoftReference;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public abstract class Promise<RESP extends Response<RESP,IC,XC>,REQ extends Request<REQ,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> implements Future<RESP> {

    protected final REQ request;
    protected final Instant instantExpectedReady;
    protected final Duration durationAvailable;
    protected SoftReference<RESP> promised;

    public Promise(REQ request, Instant instantExpectedReady, Duration durationAvailable) {
        this.request = request;
        this.instantExpectedReady = instantExpectedReady;
        this.durationAvailable = durationAvailable;
    }

    public REQ getRequest() {
        return request;
    }

    public Instant getInstantExpectedReady() {
        return instantExpectedReady;
    }

    public Duration getDurationAvailable() {
        return durationAvailable;
    }

    public SoftReference<RESP> getPromised() {
        return promised;
    }
}
