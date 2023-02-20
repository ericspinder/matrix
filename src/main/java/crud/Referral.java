package crud;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.Context;

public class Referral<N extends Notion<N, Identity.SuperEgo, Context.Path,A>,A extends Model<?, N, ?, Identity.SuperEgo, Context.Path, ?, A>> {

    protected final Identity.SuperEgo service;

    public Referral(Identity.SuperEgo service) {
        this.service = service;
    }


}
