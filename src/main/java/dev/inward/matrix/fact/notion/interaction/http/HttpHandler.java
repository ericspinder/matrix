package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Resource;
import dev.inward.matrix.fact.Resources;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.corpus.Prophet;
import dev.inward.matrix.fact.notion.interaction.Handler;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class HttpHandler<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Handler<HttpHandler<IA,XA>,HttpInteraction<IA,XA>,HttpDesk<IA,XA>,HttpJournal<IA,XA>,HttpProducer<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpHandler(Prophet mortal, Resources resources, Map<Standard<?, HttpInteraction<IA,XA>, Identity.Ego, Context.JVM>, Resource<HttpHandler<IA,XA>, ?, ?, ?, HttpInteraction<IA,XA>, HttpDesk<IA,XA>, Identity.Ego, Context.JVM, HttpJournal<IA, XA>, HttpProducer<IA, XA>>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
