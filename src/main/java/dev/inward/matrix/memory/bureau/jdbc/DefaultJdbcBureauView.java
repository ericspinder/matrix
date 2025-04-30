/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.jdbc;

public final class DefaultJdbcBureauView extends JdbcBureauView<DefaultJdbcBureau,DefaultJdbcBureauView,DefaultJdbcBureauModel,DefaultJdbcBureauReference, DefaultJdbcBureauLibrarian> {
    public DefaultJdbcBureauView(String name, DefaultJdbcBureau defaultJdbcBureau, DefaultJdbcBureauReference reference) {
        super(name, defaultJdbcBureau, reference);
    }
}
