package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.Desk;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class HttpDesk<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Desk<HttpHandler<IA,XA>,HttpInteraction<IA,XA>,HttpDesk<IA,XA>,HttpJournal<IA,XA>,HttpProducer<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpDesk(Specification specification, Supplier<HttpHandler<IA,XA>, HttpInteraction<IA,XA>,HttpDesk<IA,XA>,Identity.Ego,Context.JVM,HttpJournal<IA,XA>,HttpProducer<IA,XA>,?,?,?,?,?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
