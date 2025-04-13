/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.jdbc;

public final class DefaultJdbcBureauReference extends JdbcBureauReference<DefaultJdbcBureauKey,DefaultJdbcBureau,DefaultJdbcBureauView,DefaultJdbcBureauModel,DefaultJdbcBureauReference,DefaultJdbcBureauGestalt> {
    public DefaultJdbcBureauReference(DefaultJdbcBureau referent, DefaultJdbcBureauGestalt geslalt) {
        super(referent, geslalt);
    }
}
