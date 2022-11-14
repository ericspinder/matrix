package dev.inward.matrix.fact.notion.interaction.http;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.Interaction;

public class HttpInteraction<IA extends Identity<IA,XA>,XA extends Context<XA>> extends Interaction<HttpInteraction<IA,XA>,HttpResponse<IA,XA>,HttpRequest<IA,XA>,IA,XA> {

    public HttpInteraction(Identity.Ego id) {
        super(id);
    }

    @Override
    public HttpResponse<IA,XA> process(HttpRequest<IA, XA> matter) {
        return null;
    }
}
