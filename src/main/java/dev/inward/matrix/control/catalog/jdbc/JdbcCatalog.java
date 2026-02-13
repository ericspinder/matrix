/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.jdbc;

import dev.inward.matrix.concept.fact.FactView;

import java.util.Map;
import java.util.ResourceBundle;

public abstract class JdbcCatalog<BC extends JdbcCatalog<BC,BV,BM>,BV extends JdbcCatalogView<BC,BV,BM>,BM extends JdbcCatalogModel<BC,BV,BM>> extends ResourceBundle.Control<BC,BV,BM> {


    public JdbcCatalog(String name, boolean readOnly, BM jdbcBureauModel, Map<String, Object> attributes, Class<FactView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews) {
        super(name, readOnly, jdbcBureauModel, attributes, supportedFileViews);
    }
}
