/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.bureau.jdbc;

import dev.inward.matrix.Aspect;

public final class DefaultJdbcBureauModel extends JdbcBureauModel<DefaultJdbcBureau,DefaultJdbcBureauView,DefaultJdbcBureauModel> {
    public DefaultJdbcBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }

    @Override
    public int getDatumGenericPosition() {
        return 0;
    }
}
