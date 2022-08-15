package dev.inward.matrix.datum.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;

public class Authority extends Notion<Authority, Identity.SuperEgo,Context.Service,Judge> {
    public Authority(Identity.SuperEgo id) {
        super(id);
    }
}
