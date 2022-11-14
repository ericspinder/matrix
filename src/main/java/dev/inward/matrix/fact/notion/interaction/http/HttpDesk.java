package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.Desk;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class HttpDesk<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Desk<HttpHandler<IA,XA>,HttpInteraction<IA,XA>,HttpDesk<IA,XA>,HttpJournal<IA,XA>,HttpProducer<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpDesk(Specification specification, Supplier<HttpHandler<IA,XA>, HttpInteraction<IA,XA>,HttpDesk<IA,XA>,Identity.Ego, Context.Demarc,HttpJournal<IA,XA>,HttpProducer<IA,XA>,?,?,?,?,?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
