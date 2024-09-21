package dev.inward.matrix.fact.authoritative.notion.interaction.http;

import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.interaction.Journal;

public class HttpJournal<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Journal<HttpHandler<IA,XA>,HttpInteraction<IA,XA>,HttpDesk<IA,XA>,HttpJournal<IA,XA>,HttpProducer<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {
    public HttpJournal(HttpDesk<IA, XA> operational) {
        super(operational);
    }
}
