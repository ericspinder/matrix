package dev.inward.matrix.fact.authoritative.notion.interaction.http;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.interaction.Interaction;

public class HttpInteraction<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Interaction<HttpInteraction<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpInteraction(Identity.Ego id) {
        super(id);
    }

    @Override
    public HttpResponse<IA,XA> process(HttpRequest<IA, XA> matter) {
        return null;
    }
}
