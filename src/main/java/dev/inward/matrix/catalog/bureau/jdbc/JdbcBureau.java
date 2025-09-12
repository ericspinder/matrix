/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.bureau.jdbc;

import dev.inward.matrix.catalog.bureau.Bureau;
import dev.inward.matrix.file.FileView;

import java.util.Map;

public abstract class JdbcBureau<BC extends JdbcBureau<BC,BV,BM>,BV extends JdbcBureauView<BC,BV,BM>,BM extends JdbcBureauModel<BC,BV,BM>> extends Bureau<BC,BV,BM> {


    public JdbcBureau(String name, boolean readOnly, BM jdbcBureauModel, Map<String, Object> attributes, Class<FileView<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>[] supportedFileViews) {
        super(name, readOnly, jdbcBureauModel, attributes, supportedFileViews);
    }
}
