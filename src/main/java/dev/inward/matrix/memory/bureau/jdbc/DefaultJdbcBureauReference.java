/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.jdbc;

public final class DefaultJdbcBureauReference extends JdbcBureauReference<DefaultJdbcBureau,DefaultJdbcBureauView,DefaultJdbcBureauModel,DefaultJdbcBureauReference, DefaultJdbcBureauLibrarian> {
    public DefaultJdbcBureauReference(DefaultJdbcBureau referent, DefaultJdbcBureauLibrarian geslalt) {
        super(referent, geslalt);
    }
}
