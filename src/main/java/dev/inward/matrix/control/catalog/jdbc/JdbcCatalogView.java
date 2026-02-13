/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.jdbc;

import dev.inward.matrix.control.administration.BureauView;

public class JdbcCatalogView<BC extends JdbcCatalog<BC,BV,BM>,BV extends JdbcCatalogView<BC,BV,BM>,BM extends JdbcCatalogModel<BC,BV,BM>> extends BureauView<BC,BV,BM> {

    public JdbcCatalogView(String name, BC jdbcBureau) {
        super(name, jdbcBureau);
    }
}
