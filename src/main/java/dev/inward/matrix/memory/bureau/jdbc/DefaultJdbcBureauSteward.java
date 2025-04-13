/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.jdbc;

import dev.inward.matrix.file.addressed.depot.standard.Standard;

public final class DefaultJdbcBureauSteward extends JdbcBureauSteward<DefaultJdbcBureauKey,DefaultJdbcBureau,DefaultJdbcBureauView,DefaultJdbcBureauModel,DefaultJdbcBureauReference, DefaultJdbcBureauSteward> {
    public DefaultJdbcBureauSteward(Standard standard) {
        super(standard);
    }
}
