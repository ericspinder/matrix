/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.jdbc;

import dev.inward.matrix.container.catalog.Catalog;

import java.net.URI;

public final class DefaultJdbcBureauKey extends JdbcBureauKey<DefaultJdbcBureauKey,DefaultJdbcBureau,DefaultJdbcBureauView,DefaultJdbcBureauModel,DefaultJdbcBureauReference,DefaultJdbcBureauGestalt> {

    protected final Catalog<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> catalog;
    protected DefaultJdbcBureauKey(URI uri, Catalog<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> catalog) {
        super(uri);
        this.catalog = catalog;
    }

    public Catalog<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getCatalog() {
        return catalog;
    }
}
