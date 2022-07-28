package dev.inward.matrix.fact.intialized.maker.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.intialized.maker.Maker;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.http.HttpRequest;
import dev.inward.matrix.fact.notion.interaction.http.HttpResponse;

public final class Http<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Maker<Http<IH,XH>,HttpEscalation<IH,XH>,HttpPromise<IH,XH>, HttpResponse<IH,XH>, HttpRequest<IH,XH>,IH,XH> {

    public Http(Identity.Ego id) {
        super(id);
    }

    @Override
    public HttpPromise<IH, XH> request(HttpRequest<IH, XH> request) {
        return null;
    }

    @Override
    public HttpPromise<IH,XH> validate(HttpPromise<IH,XH> promise) {
        return null;
    }

    @Override
    public HttpEscalation<IH,XH> cancel(HttpPromise<IH,XH> promise) {
        return null;
    }
}
