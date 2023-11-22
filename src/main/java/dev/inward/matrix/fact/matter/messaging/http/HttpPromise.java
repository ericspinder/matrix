package dev.inward.matrix.fact.matter.messaging.http;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.interaction.http.HttpRequest;
import dev.inward.matrix.fact.authoritative.notion.interaction.http.HttpResponse;
import dev.inward.matrix.phenomenon.producer.promise.Promise;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HttpPromise<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Promise<HttpPromise<IH,XH>,HttpResponse<IH,XH>,HttpRequest<IH,XH>,IH,XH> {

    public HttpPromise(HttpRequest<IH, XH> request, Instant instantExpectedReady, Duration durationAvailable) {
        super(request, instantExpectedReady, durationAvailable);
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public HttpResponse<IH, XH> get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public HttpResponse<IH, XH> get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}

