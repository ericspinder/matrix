/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.jdbc;

import dev.inward.matrix.control.bureau.BureauView;

public class JdbcBureauView<BC extends JdbcBureau<BC,BV,BM>,BV extends JdbcBureauView<BC,BV,BM>,BM extends JdbcBureauModel<BC,BV,BM>> extends BureauView<BC,BV,BM> {

    public JdbcBureauView(String name, BC jdbcBureau) {
        super(name, jdbcBureau);
    }
}
