/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;

import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.Context;

public class Referral<N extends Notion<N, Identity.Gate, Context.Path,A>,A extends Model<?, N, ?, Identity.Gate, Context.Path, ?, A>> {

    protected final Identity.Gate service;

    public Referral(Identity.Gate service) {
        this.service = service;
    }


}
