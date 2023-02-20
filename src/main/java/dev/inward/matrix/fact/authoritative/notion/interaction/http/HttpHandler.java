package dev.inward.matrix.fact.authoritative.notion.interaction.http;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.house.Steward;
import dev.inward.matrix.fact.authoritative.notion.interaction.Handler;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public class HttpHandler<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Handler<HttpHandler<IA,XA>,HttpInteraction<IA,XA>,HttpDesk<IA,XA>,HttpJournal<IA,XA>,HttpProducer<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpHandler(Steward mortal, Storage storage, Map<Standard<?, HttpInteraction<IA,XA>, Identity.Ego, Context.Demarc>, Resource<HttpHandler<IA,XA>, ?, ?, ?, HttpInteraction<IA,XA>, HttpDesk<IA,XA>, Identity.Ego, Context.Demarc, HttpJournal<IA, XA>, HttpProducer<IA, XA>>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
