package dev.inward.matrix.datum.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.house.Steward;
import dev.inward.matrix.datum.fact.notion.interaction.Handler;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public class HttpHandler<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Handler<HttpHandler<IA,XA>,HttpInteraction<IA,XA>,HttpDesk<IA,XA>,HttpJournal<IA,XA>,HttpProducer<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpHandler(Steward mortal, Storage storage, Map<Standard<?, HttpInteraction<IA,XA>, Identity.Ego, Context.Demarc>, Resource<HttpHandler<IA,XA>, ?, ?, ?, HttpInteraction<IA,XA>, HttpDesk<IA,XA>, Identity.Ego, Context.Demarc, HttpJournal<IA, XA>, HttpProducer<IA, XA>>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
