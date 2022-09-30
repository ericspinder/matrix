package dev.inward.matrix.matter.maker.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.matter.maker.Maker;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.interaction.http.HttpRequest;
import dev.inward.matrix.datum.fact.notion.interaction.http.HttpResponse;

public class Http<IH extends Identity<IH,XH>,XH extends Context<XH>> extends Maker<Http<IH,XH>,HttpModification<IH,XH>,HttpEscalation<IH,XH>,HttpAdvice<IH,XH>,HttpPromise<IH,XH>, HttpResponse<IH,XH>, HttpRequest<IH,XH>,IH,XH> {

    public Http(Identity.Ego id) {
        super(id);
    }

    @Override
    public HttpPromise<IH, XH> request(HttpRequest<IH, XH> request) {
        return null;
    }

    @Override
    public HttpAdvice<IH,XH> validate(HttpPromise<IH,XH> promise) {
        return null;
    }

    @Override
    public HttpEscalation<IH,XH> modification(HttpModification<IH,XH> modification) {
        return null;
    }
}
