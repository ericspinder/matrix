/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.jdbc;

import dev.inward.matrix.Aspect;

public final class DefaultJdbcCatalogModel extends JdbcCatalogModel<DefaultJdbcCatalog, DefaultJdbcCatalogView, DefaultJdbcCatalogModel> {
    public DefaultJdbcCatalogModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }

}
