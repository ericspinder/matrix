package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.*;

import java.lang.ref.ReferenceQueue;

public class HttpProducer<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Producer<HttpHandler<IA,XA>,HttpInteraction<IA,XA>,HttpDesk<IA,XA>,HttpJournal<IA,XA>,HttpProducer<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpProducer(HttpInteraction<IA, XA> fact, ReferenceQueue<HttpInteraction<IA, XA>> referenceQueue, HttpJournal<IA, XA> omnibus, HttpDesk<IA, XA> aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
