package dev.inward.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Referral<N extends Notion<N, Identity.SuperEgo, Context.Service,A>,A extends Ambassador<?,N,?, Identity.SuperEgo, Context.Service,?,A>> {

    protected final Identity.SuperEgo service;

    public Referral(Identity.SuperEgo service) {
        this.service = service;
    }


}
