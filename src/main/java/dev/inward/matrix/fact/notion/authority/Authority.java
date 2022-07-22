package dev.inward.matrix.fact.notion.authority;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;

public class Authority extends Notion<Authority, Identity.SuperEgo,Context.Service, Judge> {
    public Authority(Identity.SuperEgo id) {
        super(id);
    }
}
