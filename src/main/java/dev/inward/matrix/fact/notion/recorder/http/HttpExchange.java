package dev.inward.matrix.fact.notion.recorder.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.recorder.Recorder;

public class HttpExchange<I extends Identity<I,X>,X extends Context<X>> extends Recorder<HttpResponse<I,X>,HttpRequest<I,X>,I,X> {

    public HttpExchange(Identity.Ego id) {
        super(id);
    }

    @Override
    public HttpResponse<I, X> process(HttpRequest<I, X> matter) {
        return null;
    }
}
